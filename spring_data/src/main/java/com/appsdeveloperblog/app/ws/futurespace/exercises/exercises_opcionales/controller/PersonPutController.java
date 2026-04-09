package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.controller;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.entities.Person;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.repositories.PersonRepository;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.exceptions.PersonServiceException;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para el Ejercicio 3: Actualización de datos de personas.
 * Implementa el método PUT para modificar registros existentes identificados por su DNI.
 */
@RestController
@RequestMapping("/persons")
public class PersonPutController {

    private final PersonRepository personRepository;

    public PersonPutController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Actualiza la información de una persona buscando por su DNI.
     *
     * @param dni           DNI capturado de la ruta (Path Variable).
     * @param personDetails Objeto Person recibido en el Body de la petición con los nuevos datos.
     * @return La entidad Person actualizada y persistida.
     * @throws PersonServiceException Si el DNI no existe en la base de datos.
     */
    @PutMapping(value = "/{dni}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
            },
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
            })
    public Person updatePerson(@PathVariable String dni, @Valid @RequestBody Person personDetails) {

        // Buscamos a la persona por su DNI
        // Usamos el método que añadimos al repositorio. Si no existe, lanzamos nuestra excepción.
        Person existingPerson = personRepository.findByDni(dni)
                .orElseThrow(() -> new PersonServiceException("No se ha podido actualizar: El DNI " + dni + " no existe."));

        // Mapeamos los nuevos datos del Body a la persona que ya existe en la DB
        // IMPORTANTE: No cambiamos el ID ni el DNI original.
        existingPerson.setFirstName(personDetails.getFirstName());
        existingPerson.setLastName(personDetails.getLastName());
        existingPerson.setSecondLastName(personDetails.getSecondLastName());
        existingPerson.setBirthDate(personDetails.getBirthDate());
        existingPerson.setGender(personDetails.getGender());

        // Guardamos los cambios (Spring Data JPA detecta que ya existe por el ID y hace un UPDATE)
        Person updatedPerson = personRepository.save(existingPerson);

        // Log de auditoria por consola
        System.out.println("Actualización realizada: Datos modificados para el DNI " + dni + " (" + updatedPerson.getFullName() + ")");

        return updatedPerson;
    }
}