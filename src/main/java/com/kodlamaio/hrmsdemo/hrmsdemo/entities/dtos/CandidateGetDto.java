package com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateGetDto {

    private int id;

    private String email;

    private String firstName;

    private String lastName;

    private long nationalId;

    private String birthYear;
}
