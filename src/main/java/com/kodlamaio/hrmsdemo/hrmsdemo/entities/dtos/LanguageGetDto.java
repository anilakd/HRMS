package com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageGetDto {

    private int id;
    private String languageName;

    private int level;
}
