package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Education;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EducationAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EducationGetDto;

import java.util.List;

public interface EducationService {


    Result add(EducationAddDto abilityAddDto);
    DataResult<List<EducationGetDto>> getAll();
    void add(Education education);
}
