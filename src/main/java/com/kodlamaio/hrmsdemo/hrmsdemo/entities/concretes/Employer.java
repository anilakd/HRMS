package com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User {


    @Column(name="company_name")
    private String companyName;

    @Column(name="web_page")
    private String webPage;

    @Column(name="phone_number")
    private String phoneNumber;



    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;


}
