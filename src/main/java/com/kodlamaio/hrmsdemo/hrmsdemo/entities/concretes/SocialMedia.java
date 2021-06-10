package com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "social_medias")
public class SocialMedia {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name="gihub_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;


    @OneToOne()
    @JoinColumn(name = "cv_id")
    private CV cv;
}
