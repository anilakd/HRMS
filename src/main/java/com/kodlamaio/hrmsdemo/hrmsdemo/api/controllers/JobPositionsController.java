package com.kodlamaio.hrmsdemo.hrmsdemo.api.controllers;


import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.JobPositionService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.JobPosition;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobPositionAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobPositionGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobPositions")
public class JobPositionsController {

    private final JobPositionService jobPositionService;


    @Autowired
    public JobPositionsController(JobPositionService jobPositionService){
        this.jobPositionService=jobPositionService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPositionGetDto>> getAll(){
        return this.jobPositionService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPositionAddDto jobPositionAddDto){
        return this.jobPositionService.add(jobPositionAddDto);
    }
}
