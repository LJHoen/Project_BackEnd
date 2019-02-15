package com.project.eatme.services;

import com.project.eatme.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountService extends CrudRepository<Account, Long> {



}
