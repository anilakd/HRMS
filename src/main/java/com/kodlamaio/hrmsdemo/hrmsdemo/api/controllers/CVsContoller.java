package com.kodlamaio.hrmsdemo.hrmsdemo.api.controllers;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.CVService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CVAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/cv")
@RequiredArgsConstructor
public class CVsContoller {

    private final CVService cvService;

    @PostMapping("/add")
    Result add(@RequestBody CVAddDto cvAddDto){
        return this.cvService.add(cvAddDto);
    }


    @PostMapping("/addImage")
    public Result saveImage(@RequestBody MultipartFile file, @RequestParam int id) {
        return this.cvService.saveImage(file, id);

    }
}
