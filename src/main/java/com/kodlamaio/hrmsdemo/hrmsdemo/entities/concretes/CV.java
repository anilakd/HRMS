package com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="curriculum_vitaes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations","abilities","workExperiences","languages"})

public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @OneToMany(mappedBy = "cv")
    private List<Education> educations;


    @OneToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @OneToMany(mappedBy = "cv")
    private List<Ability> abilities;

    @OneToMany(mappedBy = "cv")
    private List<WorkExperience> workExperiences;

    @OneToMany(mappedBy = "cv")
    private List<Language> languages;

    @OneToOne(mappedBy = "cv")
    private SocialMedia socialMedia;

    @Column(name="image")
    private String image;



}
