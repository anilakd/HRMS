package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.CityService;
import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.EmployerService;
import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.JobAdvertisementDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.JobPositionDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.City;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Employer;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.JobAdvertisement;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.JobPosition;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobAdvertisementAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.JobAdvertisementGetDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private final JobAdvertisementDao jobAdvertisementDao;
    private final ModelMapper modelMapper;
    private final CityService cityService;
    private final EmployerService employerService;
    private final JobPositionDao jobPositionDao;


    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,
                                   ModelMapper modelMapper,
                                   CityService cityService,
                                   EmployerService employerService,
                                   JobPositionDao jobPositionDao){
        this.jobAdvertisementDao= jobAdvertisementDao;
        this.modelMapper= modelMapper;
        this.cityService= cityService;
        this.employerService= employerService;
        this.jobPositionDao= jobPositionDao;
    }

    @Override
    public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {
        City city = this.cityService.getById(jobAdvertisementAddDto.getCityId());
        Employer employer = this.employerService.getById(jobAdvertisementAddDto.getEmployerId());
        JobPosition jobPosition= this.jobPositionDao.getById(jobAdvertisementAddDto.getJobPositionId());
        JobAdvertisement jobAdvertisement = this.modelMapper.map(jobAdvertisementAddDto, JobAdvertisement.class);
        jobAdvertisement.setCity(city);
        jobAdvertisement.setEmployer(employer);
        jobAdvertisement.setJobPosition(jobPosition);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public DataResult<List<JobAdvertisementGetDto>> getAll() {
        List<JobAdvertisement> list = this.jobAdvertisementDao.findAll();
        List<JobAdvertisementGetDto> resultList = list.stream().map(item->new JobAdvertisementGetDto(item.getDetail(),
                item.getNumberOfJobPostings(),
                item.getCity().getId(),
                item.getEmployer().getId(),item.getMaxSalary(),item.getMinSalary(), item.getDeadline(),item.getJobPosition().getId())).collect(Collectors.toList());
        return new SuccessDataResult<>(resultList,"Başarıyla getirildi");
    }

    @Override
    public DataResult<List<JobAdvertisementGetDto>> getByEmployerId(int id) {
        List<JobAdvertisement> list= this.jobAdvertisementDao.getAllByEmployer_Id(id);
        List<JobAdvertisementGetDto> resultList = list.stream().map(item->new JobAdvertisementGetDto(item.getDetail(),
                item.getNumberOfJobPostings(),
                item.getCity().getId(),
                item.getEmployer().getId(),item.getMaxSalary(),item.getMinSalary(), item.getDeadline(),item.getJobPosition().getId())).collect(Collectors.toList());
        return  new SuccessDataResult<>(resultList,"Başarıyla getirildi");
    }


}
