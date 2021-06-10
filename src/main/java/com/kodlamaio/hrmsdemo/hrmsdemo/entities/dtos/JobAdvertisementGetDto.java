package com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementGetDto {

    private String detail;

    private int numberOfJobPostings;

    private int cityId;

    private int employerId;

    private double maxSalary;

    private double minSalary;

    private LocalDate deadline;

    private int jobPositionId;
}
