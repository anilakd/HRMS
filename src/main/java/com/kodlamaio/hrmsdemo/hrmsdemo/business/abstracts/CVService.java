package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CVAddDto;
import org.springframework.web.multipart.MultipartFile;

public interface CVService {


    Result add(CVAddDto cvAddDto);
    Result saveImage(MultipartFile file, int id);
}
