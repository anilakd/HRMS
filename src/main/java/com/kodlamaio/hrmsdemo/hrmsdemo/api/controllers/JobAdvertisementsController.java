package com.kodlamaio.hrmsdemo.hrmsdemo.api.controllers;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.JobAdvertisement;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobAdvertisementAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobAdvertisementGetDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobAdvertisement")
public class JobAdvertisementsController {

    private final JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService= jobAdvertisementService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisementAddDto jobAdvertisementAddDto){
        return this.jobAdvertisementService.add(jobAdvertisementAddDto);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisementGetDto>> getAll(){
        return this.jobAdvertisementService.getAll();
    }


    @GetMapping("/getAllByEmployerId")
    public DataResult<List<JobAdvertisementGetDto>> getAllByCompanyId(@RequestParam int id){
        return this.jobAdvertisementService.getByEmployerId(id);

    }

}
