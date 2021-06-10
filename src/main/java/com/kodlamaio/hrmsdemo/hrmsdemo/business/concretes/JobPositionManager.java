package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.JobPositionService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.*;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.JobPositionDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.JobPosition;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobPositionAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobPositionGetDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobPositionManager implements JobPositionService {

    private final JobPositionDao jobPositionDao;
    private final ModelMapper modelMapper;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao, ModelMapper modelMapper){
        this.jobPositionDao=jobPositionDao;
        this.modelMapper= modelMapper;
    }

    @Override
    public Result add(JobPositionAddDto jobPositionAddDto) {
        if(jobPositionDao.existsByJobPositionName(jobPositionAddDto.getJobPositionName())){

            return new ErrorResult("Bu Pozisyon Daha Önce Eklendi");
        }

        JobPosition jobPosition = this.modelMapper.map(jobPositionAddDto, JobPosition.class);
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Pozisyon eklendi");
    }

    @Override
    public DataResult<List<JobPositionGetDto>> getAll() {
        List<JobPosition> jobPositions= this.jobPositionDao.findAll();
        List<JobPositionGetDto> resultList= jobPositions.stream().map(item->this.modelMapper.map(item, JobPositionGetDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(resultList);
    }
}
