package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.AbilityService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.AbilityDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Ability;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.AbilityAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.AbilityGetDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AbilityManager implements AbilityService {

    private final AbilityDao abilityDao;
    private final ModelMapper modelMapper;


    @Override
    public Result add(AbilityAddDto abilityAddDto) {
        Ability ability = this.modelMapper.map(abilityAddDto, Ability.class);
        abilityDao.save(ability);
        return new SuccessResult("Başarıyla kaydedildi");
    }

    @Override
    public void add(Ability ability) {
        this.abilityDao.save(ability);
    }

    @Override
    public DataResult<List<AbilityGetDto>> getAll() {
        List<Ability> abilities= this.abilityDao.findAll();
        List<AbilityGetDto> resultList= abilities.stream().map(item-> this.modelMapper.map(item, AbilityGetDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(resultList,"Başarıyla getirildi");
    }

    @Override
    public Ability findByAbilityDetail(String abilityDetail) {
        return this.abilityDao.findByAbilityDetail(abilityDetail);
    }

}
