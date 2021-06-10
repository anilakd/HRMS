package com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class EducationGetDto {

    private int id;

    private String schoolName;


    private String departmentName;


    private LocalDate startDate;


    private LocalDate endDate;
}
