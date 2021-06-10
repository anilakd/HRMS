package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.City;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CityAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CityGetDto;

import java.util.List;

public interface CityService {

    Result add(CityAddDto cityAddDto);
    DataResult<List<CityGetDto>> getAll();
    City getById(int id);

}
