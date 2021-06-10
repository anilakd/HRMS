package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Language;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.LanguageAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.LanguageGetDto;

import java.util.List;


public interface LanguageService {

    Result add(LanguageAddDto languageAddDto);
    DataResult<List<LanguageGetDto>> getAll();

    void add(Language language);
}
