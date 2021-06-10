package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.JobAdvertisement;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobAdvertisementAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobAdvertisementGetDto;

import java.util.List;

public interface JobAdvertisementService {

    Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
    DataResult<List<JobAdvertisementGetDto>> getAll();

    DataResult<List<JobAdvertisementGetDto>> getByEmployerId(int id);
}
