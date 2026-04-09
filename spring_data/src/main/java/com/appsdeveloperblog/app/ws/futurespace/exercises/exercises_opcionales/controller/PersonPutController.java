package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.controller;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.request.PersonRequest;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.response.PersonResponse;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.service.IPersonService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para la actualización de datos de personas.
 */
@RestController
@RequestMapping("/persons")
public class PersonPutController {

    private final IPersonService personService;

    public PersonPutController(IPersonService personService) {
        this.personService = personService;
    }

    @PutMapping(value = "/{dni}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            },
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public PersonResponse updatePerson(@PathVariable String dni, @Valid @RequestBody PersonRequest personRequest) {

        PersonResponse updatedPerson = personService.update(dni, personRequest);
        System.out.println("Actualización realizada para el DNI " + dni + " (" + updatedPerson.getFullName() + ")");

        return updatedPerson;
    }
}