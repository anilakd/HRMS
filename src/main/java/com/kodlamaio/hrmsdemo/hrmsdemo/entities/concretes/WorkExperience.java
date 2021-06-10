package com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_experiences")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String companyName;

    private String position;

    private LocalDate startDate;

    private LocalDate endDate;


    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private CV cv;
}
