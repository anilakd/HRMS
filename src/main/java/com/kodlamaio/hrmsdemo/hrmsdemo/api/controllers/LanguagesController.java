package com.kodlamaio.hrmsdemo.hrmsdemo.api.controllers;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.LanguageService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.LanguageAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.LanguageGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@RequiredArgsConstructor
public class LanguagesController {

    private final LanguageService languageService;

    @PostMapping("/add")
    Result add(@RequestBody LanguageAddDto languageAddDto){
        return this.languageService.add(languageAddDto);
    }

    @GetMapping("/getAll")
    DataResult<List<LanguageGetDto>> getAll(){
        return this.languageService.getAll();
    }
}
