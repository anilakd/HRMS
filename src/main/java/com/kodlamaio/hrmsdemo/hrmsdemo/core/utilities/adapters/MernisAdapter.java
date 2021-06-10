package com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.adapters;

import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.UserCheckService;
import com.kodlamaio.hrmsdemo.hrmsdemo.mernisService.EBPKPSPublicSoap;
import org.springframework.stereotype.Service;


@Service
public class MernisAdapter implements UserCheckService {

    public boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, int dateOfBirth){

        EBPKPSPublicSoap kps= new EBPKPSPublicSoap();
        boolean result=false;
        try {
            result= kps.TCKimlikNoDogrula(nationalityId,firstName,lastName,dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return result;
    }
}
