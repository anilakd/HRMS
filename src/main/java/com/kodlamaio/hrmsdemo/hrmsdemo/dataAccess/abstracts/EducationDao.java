package com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education, Integer> {
}
