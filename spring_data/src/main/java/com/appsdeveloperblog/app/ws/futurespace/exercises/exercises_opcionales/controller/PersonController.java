package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.controller;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.response.PersonResponse;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.service.IPersonService;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.exceptions.PersonServiceException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para gestionar las peticiones (Version Spring Data).
 * Expone el recurso 'persons' utilizando modelos de respuesta (Response DTO).
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PersonResponse> getPersonDetails() {
        List<PersonResponse> persons = personService.findAll();

        if (persons.isEmpty()) {
            throw new PersonServiceException("No se han encontrado registros. La tabla esta vacia.");
        }

        System.out.println("Accion realizada: Consulta de datos GET (Total: " + persons.size() + ")");
        return persons;
    }

    @GetMapping(value = "/{dni}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonResponse getPersonByDni(@PathVariable String dni) {
        return personService.findByDni(dni);
    }
}