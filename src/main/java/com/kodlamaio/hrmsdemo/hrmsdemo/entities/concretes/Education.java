package com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="school_name")
    private String schoolName;

    @Column(name="department_name")
    private String departmentName;

    @Column(name="start_day")
    private LocalDate startDate;

    @Column(name="end_Day")
    private LocalDate endDate;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private CV cv;


}
