package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.CityService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.*;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.CityDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.City;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CityAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CityGetDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityManager implements CityService {

    private final CityDao cityDao;
    private final ModelMapper modelMapper;

    @Autowired
    public CityManager(CityDao cityDao,ModelMapper modelMapper){
        this.cityDao= cityDao;
        this.modelMapper= modelMapper;

    }

    @Override
    public Result add(CityAddDto cityAddDto) {

        //Daha önce eklenmiş mi kontrol ediyor
        if(cityDao.existsByCityName(cityAddDto.getCityName())){
            return new ErrorResult("Bu şehir daha önce eklendi");
        }
        City city = this.modelMapper.map(cityAddDto, City.class);
        this.cityDao.save(city);
        return new SuccessResult("Şehir eklendi");
    }

    @Override
    public DataResult<List<CityGetDto>> getAll() {
        List<City> cities= this.cityDao.findAll();
        List<CityGetDto> resultList= cities.stream().map(item->this.modelMapper.map(item, CityGetDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(resultList,"Başarıyla getirildi");
    }

    @Override
    public City getById(int id) {
        return this.cityDao.getById(id);
    }


}
