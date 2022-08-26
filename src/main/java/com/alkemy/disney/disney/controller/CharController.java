package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.CharDTO;
import com.alkemy.disney.disney.service.CharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharController {

    @Autowired
    private CharService personajeService;


    @GetMapping
    public ResponseEntity<List<CharDTO>> getAllPersonajes() {
        List<CharDTO> personajes = personajeService.getAllCharacters();
        return ResponseEntity.ok().body(personajes);
    }



    @PostMapping
    public ResponseEntity<CharDTO> savePersonaje(@RequestBody CharDTO personaje) {
        CharDTO personajeSaved = personajeService.saveChar(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeSaved);
    }

}
