package com.kodlamaio.hrmsdemo.hrmsdemo.api.controllers;


import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.CandidateService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Candidate;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CandidateAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CandidateGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/candidates")
public class CandidateController {

    private final CandidateService candidateService;


    @Autowired
    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateAddDto candidateAddDto){
        return this.candidateService.add(candidateAddDto);
    }

    @GetMapping("/getAll")
    public DataResult<List<CandidateGetDto>> getAll(){
        return this.candidateService.findAll();
    }
}
