package com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.CV;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CVDao extends JpaRepository<CV, Integer> {
}
