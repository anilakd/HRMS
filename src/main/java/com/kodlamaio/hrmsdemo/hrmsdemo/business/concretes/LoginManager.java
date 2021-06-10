package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.LoginService;
import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.UserService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.ErrorResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginManager implements LoginService {


    private final UserService userService;

    @Autowired
    public LoginManager(UserService userService){
        this.userService=userService;
    }


    @Override
    public Result login(String email, String password) {

        if(!userService.existsByEmail(email)){
            return new ErrorResult("Bu mail ile kayıt bulunmamaktadır");
        }

        User user = userService.findByEmail(email);
        if(!user.getPassword().equals(password)){
            return new ErrorResult("Şifre hatalıdır");
        }

        if (!user.isVerified()){
            return new ErrorResult("Bu email aktif edilmemiştir");
        }

        return new SuccessResult("Giriş yapılmıştır");
    }
}
