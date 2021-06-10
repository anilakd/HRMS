package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Employer;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EmployerAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EmployerGetDto;

import java.util.List;

public interface EmployerService  {

    Result add(EmployerAddDto employerAddDto);
    DataResult<List<EmployerGetDto>> findAll();
    Employer getById(int id);
}
