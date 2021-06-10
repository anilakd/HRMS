package com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts;

import java.time.LocalDate;

public interface UserCheckService {

    boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, int dateOfBirth);
}
