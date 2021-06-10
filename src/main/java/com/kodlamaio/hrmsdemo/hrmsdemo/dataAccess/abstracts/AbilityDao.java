package com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Ability;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.AbilityAddDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbilityDao extends JpaRepository<Ability , Integer> {

    Ability findByAbilityDetail(String abilityDetail);
    boolean existsAbilityByAbilityDetail(String detail);

}
