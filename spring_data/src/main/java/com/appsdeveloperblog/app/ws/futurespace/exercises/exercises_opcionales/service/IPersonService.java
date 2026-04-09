package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.service;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.request.PersonRequest;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.response.PersonResponse;

import java.util.List;

/**
 * Interfaz de servicios para la gestión de personas.
 * Refactorizada para usar modelos de Request/Response, siguiendo los principios de Clean Code.
 * * @author Susana Bitar
 */
public interface IPersonService {
    List<PersonResponse> findAll();

    PersonResponse findByDni(String dni);

    PersonResponse save(PersonRequest personRequest);

    PersonResponse update(String dni, PersonRequest personRequest);
}