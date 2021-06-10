package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.EducationService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.EducationDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Education;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EducationAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EducationGetDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EducationManager implements EducationService {

    private final EducationDao educationDao;
    private final ModelMapper modelMapper;

    @Override
    public Result add(EducationAddDto educationAddDto) {
        Education education= this.modelMapper.map(educationAddDto, Education.class);
        this.educationDao.save(education);
        return new SuccessResult("Başarıyla kaydedildi");
    }

    @Override
    public DataResult<List<EducationGetDto>> getAll() {
        List<Education> educations= this.educationDao.findAll();
        List<EducationGetDto> resultList= educations.stream().map(item-> this.modelMapper.map(item, EducationGetDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(resultList,"Başarıyla oluşturuldu");
    }

    @Override
    public void add(Education education) {
        this.educationDao.save(education);
    }


}
