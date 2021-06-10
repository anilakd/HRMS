package com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPositionGetDto {


    private int id;

    private String jobPositionName;
}
