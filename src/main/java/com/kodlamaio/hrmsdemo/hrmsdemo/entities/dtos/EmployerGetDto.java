package com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployerGetDto {

    private String companyName;
    private String email;
    private String phoneNumber;
    private String webPage;
    private boolean isVerified;

}
