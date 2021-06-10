package com.kodlamaio.hrmsdemo.hrmsdemo.api.controllers;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.EducationService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EducationAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EducationGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@RequiredArgsConstructor
public class EducationsController {

    private final EducationService educationService;


    @PostMapping("/add")
    Result add(@RequestBody EducationAddDto educationAddDto){
        return this.educationService.add(educationAddDto);
    }

    @GetMapping("/getAll")
    DataResult<List<EducationGetDto>> getAll(){
        return this.educationService.getAll();
    }
}
