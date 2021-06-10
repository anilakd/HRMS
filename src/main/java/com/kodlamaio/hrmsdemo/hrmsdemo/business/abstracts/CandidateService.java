package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Candidate;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CandidateAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CandidateGetDto;

import java.util.List;

public interface CandidateService {

    Result add(CandidateAddDto candidateAddDto);
    DataResult<List<CandidateGetDto>> findAll();
    DataResult<Candidate> findByEmail(String email);
    Candidate findById(int id);
}
