package com.manoelh.personapi.controller;

import com.manoelh.personapi.dto.MessageResponseDTO;
import com.manoelh.personapi.dto.PersonDTO;
import com.manoelh.personapi.exception.personNotFoundException;
import com.manoelh.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")

public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO) {
        return this.personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAllPeople() {
        return this.personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findOnePerson(@PathVariable Long id) throws personNotFoundException {
        return this.personService.findOnePerson(id);
    }
}
