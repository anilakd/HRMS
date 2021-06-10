package com.kodlamaio.hrmsdemo.hrmsdemo.api.controllers;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.SocialMediaService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.SocialMediaAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.SocialMediaGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socialmedias")
@RequiredArgsConstructor
public class SocialMediasController {

    private final SocialMediaService socialMediaService;


    @PostMapping ("/add")
    Result add(@RequestBody SocialMediaAddDto socialMediaAddDto){
        return this.socialMediaService.add(socialMediaAddDto);
    }

    @GetMapping("/getAll")
    DataResult<List<SocialMediaGetDto>> getAll(){
        return this.socialMediaService.getAll();
    }
}
