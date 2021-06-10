package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.User;

public interface UserService {
    boolean existsByEmail(String email);

    User findByEmail(String email);
}
