package com.kodlamaio.hrmsdemo.hrmsdemo.api.controllers;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.AbilityService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.AbilityAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.AbilityGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
@RequiredArgsConstructor
public class AbilitiesController {

    private final AbilityService abilityService;

    @PostMapping("/add")
    Result add(@RequestBody AbilityAddDto abilityAddDto){
        return this.abilityService.add(abilityAddDto);
    }

    @GetMapping("/getAll")
    DataResult<List<AbilityGetDto>> getAll(){
        return this.abilityService.getAll();
    }
}
