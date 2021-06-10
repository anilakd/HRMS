package com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class CandidateAddDto {



    private String email;


    private String password;

    private String firstName;


    private String lastName;


    private long nationalId;


    private String birthYear;

}
