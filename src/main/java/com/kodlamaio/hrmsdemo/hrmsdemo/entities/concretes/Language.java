package com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name = "language_name")
    private String languageName;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private CV cv;


    @Column(name="level")
    @Range(min = 1, max = 5, message = "1-5")
    private int level;
}
