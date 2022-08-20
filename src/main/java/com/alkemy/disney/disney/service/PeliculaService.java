package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.repository.IPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService implements IPeliculaService {

    @Autowired
    private IPeliculaRepository peliRepo;
}
