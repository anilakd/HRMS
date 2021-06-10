package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.EmployerService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.*;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.EmployerUserDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Employer;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EmployerAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EmployerGetDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployerManager implements EmployerService {


    private final EmployerUserDao employerDao;
    private final ModelMapper modelMapper;


    @Autowired
    public EmployerManager(EmployerUserDao employerDao, ModelMapper modelMapper){
        this.employerDao=employerDao;
        this.modelMapper=modelMapper;
    }

    @Override
    public Result add(EmployerAddDto employerAddDto) {
        Employer employer = this.modelMapper.map(employerAddDto,Employer.class);


        if(employerDao.existsByEmail(employer.getEmail())){
            return new ErrorResult("Bu mail kullanımda");
        }

        employerDao.save(employer);
        return new SuccessResult("Başarıyla eklendi");
    }


    @Override
    public DataResult<List<EmployerGetDto>> findAll() {
        List<Employer> employers= employerDao.findAll();
        List<EmployerGetDto> resultEmployers = employers.stream().map(item->this.modelMapper.map(item, EmployerGetDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(resultEmployers);
    }

    @Override
    public Employer getById(int id) {
        return this.employerDao.getById(id);
    }
}
