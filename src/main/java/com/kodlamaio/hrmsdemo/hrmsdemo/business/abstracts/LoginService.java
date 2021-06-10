package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;

public interface LoginService {

    Result login(String mail, String password);

}
