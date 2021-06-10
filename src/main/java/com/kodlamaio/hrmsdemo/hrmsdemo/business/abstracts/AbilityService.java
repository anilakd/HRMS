package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Ability;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.AbilityAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.AbilityGetDto;

import java.util.List;

public interface AbilityService {

    Result add(AbilityAddDto abilityAddDto);
    void add(Ability ability);
    DataResult<List<AbilityGetDto>> getAll();
    Ability findByAbilityDetail(String abilityDetail);
}
