package com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Candidate;

public interface CandidateUserDao extends UserDao<Candidate> {


    boolean existsByNationalId(long tcKimlikNo);
    Candidate findById(int id);

}
