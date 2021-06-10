package com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee extends User{

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;


}
