package com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")
public class JobAdvertisement {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="job_advertisement_detail")
    private String detail;

    @Column(name="number_of_job_postings")
    private int numberOfJobPostings;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name="employer_id")
    private Employer employer;

    @Column(name="max_salary")
    private double maxSalary;

    @Column(name="min_salary")
    private double minSalary;

    @Column(name="deadline")
    private LocalDate deadline;


    @ManyToOne()
    @JoinColumn(name="job_position_id")
    private JobPosition jobPosition;
}
