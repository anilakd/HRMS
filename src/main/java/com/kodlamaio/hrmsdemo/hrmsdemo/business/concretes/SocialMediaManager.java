package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.SocialMediaService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.SocialMediaDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.SocialMedia;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.SocialMediaAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.SocialMediaGetDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SocialMediaManager implements SocialMediaService {

    private final SocialMediaDao socialMediaDao;
    private final ModelMapper modelMapper;



    @Override
    public Result add(SocialMediaAddDto socialMediaAddDto) {
        SocialMedia socialMedia = this.modelMapper.map(socialMediaAddDto, SocialMedia.class);
        this.socialMediaDao.save(socialMedia);
        return new SuccessResult("Başarıyla kaydedildi");
    }

    @Override
    public DataResult<List<SocialMediaGetDto>> getAll() {
        List<SocialMedia> socialMediaList= this.socialMediaDao.findAll();
        List<SocialMediaGetDto> resultList= socialMediaList.stream().map(item->this.modelMapper.map(item,SocialMediaGetDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(resultList,"Başarıyla getirildi");
    }

    @Override
    public void add(SocialMedia socialMedia) {
        this.socialMediaDao.save(socialMedia);
    }

    @Override
    public SocialMedia getByCvId(int id) {
        return this.socialMediaDao.getByCv_Id(id);
    }


}
