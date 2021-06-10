package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.LanguageService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.LanguageDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Language;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.LanguageAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.LanguageGetDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguageManager implements LanguageService {


    private final LanguageDao languageDao;
    private final ModelMapper modelMapper;


    @Override
    public Result add(LanguageAddDto languageAddDto) {
        Language language = this.modelMapper.map(languageAddDto, Language.class);
        languageDao.save(language);
        return new SuccessResult("Başarıyla oluşturuldu");
    }

    @Override
    public DataResult<List<LanguageGetDto>> getAll() {
        List<Language> languages= this.languageDao.findAll();
        List<LanguageGetDto> resultList= languages.stream().map(item-> this.modelMapper.map(item, LanguageGetDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(resultList,"Başarıyla oluşturuldu");
    }

    @Override
    public void add(Language language) {
        languageDao.save(language);
    }


}
