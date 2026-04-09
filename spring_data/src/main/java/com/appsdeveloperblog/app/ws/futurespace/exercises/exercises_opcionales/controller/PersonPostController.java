package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.controller;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.request.PersonRequest;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.response.PersonResponse;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.service.IPersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para altas de personas.
 * Utiliza PersonRequest para validar la entrada y PersonResponse para la salida.
 */
@RestController
@RequestMapping("/persons")
public class PersonPostController {

    private final IPersonService personService;

    public PersonPostController(IPersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/envioFormulario",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponse processForm(@Valid @ModelAttribute PersonRequest personRequest) {

        PersonResponse savedPerson = personService.save(personRequest);
        System.out.println("Accion realizada: Envio de Formulario POST para " + savedPerson.getFullName());

        return savedPerson;
    }
}