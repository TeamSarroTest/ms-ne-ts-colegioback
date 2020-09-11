package com.hg.microservices.services;

import com.hg.microservices.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private IPersonRepository iPersonRepository;

    public void deletePerson(String id)
    {
        iPersonRepository.deleteById(id);
    }
}
