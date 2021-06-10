package com.kodlamaio.hrmsdemo.hrmsdemo.api.controllers;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.CityService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CityAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CityGetDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cities")
public class CitiesController {


    private final CityService cityService;

    public CitiesController(CityService cityService){
        this.cityService= cityService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody CityAddDto cityAddDto){
        return cityService.add(cityAddDto);
    }

    @GetMapping("/getAll")
    public DataResult<List<CityGetDto>> getAll(){
        return this.cityService.getAll();
    }
}
