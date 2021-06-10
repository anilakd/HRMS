package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.JobPosition;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobPositionAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobPositionGetDto;

import java.util.List;

public interface JobPositionService {

    Result add(JobPositionAddDto jobPositionAddDto);
    DataResult<List<JobPositionGetDto>> getAll();
}
