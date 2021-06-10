package com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao<T extends User> extends JpaRepository<T , Integer> {


    T findByEmail(String email);
    boolean existsByEmail(String email);

}
