package com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao  extends JpaRepository<Language, Integer> {
}
