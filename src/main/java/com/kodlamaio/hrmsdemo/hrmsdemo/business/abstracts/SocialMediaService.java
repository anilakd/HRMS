package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.SocialMedia;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.SocialMediaAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.SocialMediaGetDto;

import java.util.List;

public interface SocialMediaService {

    Result add(SocialMediaAddDto socialMediaAddDto);
    DataResult<List<SocialMediaGetDto>> getAll();
    void add(SocialMedia socialMedia);
    SocialMedia getByCvId(int id);
}
