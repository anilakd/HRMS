package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.*;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.AbilityDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.CVDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.*;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.AbilityAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CVAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.SocialMediaAddDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CVManager implements CVService {

    private final CVDao cvDao;
    private final ModelMapper modelMapper;
    private final AbilityService abilityService;
    private final CandidateService candidateService;
    private final LanguageService languageService;
    private final EducationService educationService;
    private final SocialMediaService socialMediaService;

    @Override
    public Result add(CVAddDto cvAddDto) {
        CV cv= this.modelMapper.map(cvAddDto, CV.class);
        Candidate candidate = candidateService.findById(cvAddDto.getCandidateId());
        cv.setCandidate(candidate);

        List<Ability> abilities = cvAddDto.getAbilityAddDtos().stream()
                .map(item -> this.modelMapper.map(item, Ability.class)).collect(Collectors.toList());


        List<Education> educations=cvAddDto.getEducationAddDtos().stream()
                .map((item->this.modelMapper.map(item,Education.class))).collect(Collectors.toList());

        SocialMedia socialMedia= this.modelMapper.map(cvAddDto.getSocialMediaAddDtos(), SocialMedia.class);

        List<Language> languages=cvAddDto.getLanguageAddDtos().stream().map(item->this.modelMapper.map(item, Language.class)).collect(Collectors.toList());


        //cv.setLanguages(languages);
        // Social Media set etmede hata fırlatıyor bak
        // cv.setSocialMedia(socialMedia);
        //cv.setEducations(educations);
        //cv.setAbilities(abilities);
        this.cvDao.save(cv);


        socialMedia.setCv(cvDao.getById(cv.getId()));
        socialMediaService.add(socialMedia);

        for(Ability ability : abilities){
            ability.setCv(cvDao.getById(cv.getId()));
            abilityService.add(ability);
        }

        for(Language language : languages){
            language.setCv(cvDao.getById(cv.getId()));
            languageService.add(language);
        }

        for(Education education : educations){
            education.setCv(cvDao.getById(cv.getId()));
            educationService.add(education);
        }

        return new SuccessResult("Başarıyla eklendi");
    }
}
