package com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaDao  extends JpaRepository<SocialMedia, Integer> {

    SocialMedia getByCv_Id(int id);
}
