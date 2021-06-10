package com.kodlamaio.hrmsdemo.hrmsdemo.api.controllers;


import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.EmployerService;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EmployerAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EmployerGetDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employers")
public class EmployersController {

    private final EmployerService employerService;

    public EmployersController(EmployerService employerService){
        this.employerService=employerService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody EmployerAddDto employerAddDto){
        //TODO Mail ile Web sitesi kontrolü yapılacak
        return this.employerService.add(employerAddDto);
    }

    @GetMapping("/getAll")
    public DataResult<List<EmployerGetDto>> getAll(){
        return this.employerService.findAll();
    }
}
