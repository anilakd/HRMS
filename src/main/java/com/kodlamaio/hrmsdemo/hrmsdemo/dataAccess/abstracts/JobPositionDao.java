package com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

    boolean existsByJobPositionName(String jobPositionName);
}
