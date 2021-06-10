package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.UserService;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.UserDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserManager implements UserService {

    private final UserDao userDao;


    @Autowired
    public UserManager(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public boolean existsByEmail(String email) {
        return userDao.existsByEmail(email);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
