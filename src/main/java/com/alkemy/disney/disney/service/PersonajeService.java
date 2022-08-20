package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService implements IPersonajeService {

    @Autowired
    private IPersonajeRepository persoRepo;
}
