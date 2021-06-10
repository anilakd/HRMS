package com.kodlamaio.hrmsdemo.hrmsdemo.business.concretes;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.CandidateService;
import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.UserCheckService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.*;
import com.kodlamaio.hrmsdemo.hrmsdemo.dataAccess.abstracts.CandidateUserDao;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.concretes.Candidate;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CandidateAddDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.CandidateGetDto;
import com.kodlamaio.hrmsdemo.hrmsdemo.entities.dtos.EmployerGetDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CandidateManager implements CandidateService {


    private final CandidateUserDao candidateDao;
    private final UserCheckService userCheckService;
    private final ModelMapper modelMapper;



    @Autowired
    public CandidateManager(CandidateUserDao candidateDao , UserCheckService userCheckService,ModelMapper modelMapper){
        this.candidateDao = candidateDao;
        this.userCheckService= userCheckService;
        this.modelMapper= modelMapper;

    }

    @Override
    public Result add(CandidateAddDto candidateAddDto) {
        Candidate candidate = this.modelMapper.map(candidateAddDto, Candidate.class);

        if(!userCheckService.checkIfRealPerson(candidate.getNationalId(),
                candidate.getFirstName(),
                candidate.getLastName(),
                Integer.parseInt(candidate.getBirthYear()))){
            return new ErrorResult("Kullanıcı doğrulanamadı");
        }

        if(candidateDao.existsByEmail(candidate.getEmail())){
            return new ErrorResult("Bu email kullanımda");
        }
        if(candidateDao.existsByNationalId(candidate.getNationalId())){
            return new ErrorResult("TC Kimlik No kullanımda");
        }

        this.candidateDao.save(candidate);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<List<CandidateGetDto>> findAll() {
        List<Candidate> candidates = this.candidateDao.findAll();
        List<CandidateGetDto> resultCandidates = candidates.stream().map(item->this.modelMapper.map(item, CandidateGetDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CandidateGetDto>>(resultCandidates,"Başarıyla Eklendi");
    }

    @Override
    public DataResult<Candidate> findByEmail(String email) {
        this.candidateDao.findByEmail(email);
        return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(email),"Başarıyla getirildi");
    }

    @Override
    public Candidate findById(int id) {
        return this.candidateDao.findById(id);
    }

}
