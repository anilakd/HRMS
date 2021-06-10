package com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos;

import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Ability;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.WorkExperience;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CVAddDto {


    private int candidateId;
    private String coverLetter;
    private List<AbilityAddDto> abilityAddDtos;
    private SocialMediaAddDto socialMediaAddDtos;
    private List<LanguageAddDto> languageAddDtos;
    private List<EducationAddDto> educationAddDtos;
}
