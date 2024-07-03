package com.betrybe.agrix.controllers;


import com.betrybe.agrix.dtos.PersonDto;
import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Person resource.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService service;

  @Autowired
  public PersonController(PersonService service) {
    this.service = service;
  }


  @PostMapping
  public ResponseEntity<PersonDto> createPerson(@RequestBody Person person) {
    Person newPerson = this.service.create(person);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new PersonDto(newPerson.getId(), newPerson.getUsername(), newPerson.getRole()));
  }
}
