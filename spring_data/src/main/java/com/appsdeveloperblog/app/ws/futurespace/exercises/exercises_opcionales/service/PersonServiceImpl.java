package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.service;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.entities.Person;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.repositories.PersonRepository;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.exceptions.PersonServiceException;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.request.PersonRequest;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.response.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación de la capa de servicio para la gestión de personas.
 * Esta clase actúa como intermediaria entre los controladores y el repositorio,
 * gestionando la lógica de negocio y la transformación de datos (Mapping).
 */
@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    /**
     * Recupera todas las personas y las transforma a formato de respuesta.
     *
     * @return Lista de PersonResponse con la información completa.
     */
    @Override
    public List<PersonResponse> findAll() {
        return personRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Busca una persona por su DNI.
     *
     * @param dni Documento de identidad.
     * @return Modelo de respuesta con los datos de la persona encontrada.
     * @throws PersonServiceException si el DNI no existe en el sistema.
     */
    @Override
    public PersonResponse findByDni(String dni) {
        Person person = personRepository.findByDni(dni)
                .orElseThrow(() -> new PersonServiceException("No se ha encontrado la persona con DNI: " + dni));
        return mapToResponse(person);
    }

    /**
     * Registra una nueva persona realizando la conversión de Request a Entidad.
     *
     * @param personRequest Datos de entrada validados.
     * @return Datos de la persona creada incluyendo su nuevo ID.
     */
    @Override
    public PersonResponse save(PersonRequest personRequest) {
        Person person = mapToEntity(personRequest);
        Person savedPerson = personRepository.save(person);
        return mapToResponse(savedPerson);
    }

    /**
     * Actualiza los datos de una persona existente identificada por DNI.
     *
     * @param dni           Identificador único de búsqueda.
     * @param personRequest Nuevos datos a aplicar.
     * @return Respuesta con los datos actualizados y el nombre completo calculado.
     */
    @Override
    public PersonResponse update(String dni, PersonRequest personRequest) {
        // Validación de existencia antes de operar
        Person existingPerson = personRepository.findByDni(dni)
                .orElseThrow(() -> new PersonServiceException("No se puede actualizar: DNI " + dni + " no existe."));

        // Actualización manual de campos de la entidad
        existingPerson.setFirstName(personRequest.getFirstName());
        existingPerson.setLastName(personRequest.getLastName());
        existingPerson.setSecondLastName(personRequest.getSecondLastName());
        existingPerson.setBirthDate(personRequest.getBirthDate());
        existingPerson.setGender(personRequest.getGender());

        return mapToResponse(personRepository.save(existingPerson));
    }

    // --- MÉTODOS PRIVADOS DE MAPEO (HELPERS) ---

    /**
     * Convierte una entidad de base de datos (Person) al modelo de salida (PersonResponse).
     * Mapea el ID generado y calcula el nombre completo automáticamente.
     *
     * @param person Entidad persistida.
     * @return Modelo de respuesta para la API.
     */
    private PersonResponse mapToResponse(Person person) {
        PersonResponse response = new PersonResponse();

        response.setId(person.getId()); // ID de base de datos
        response.setDni(person.getDni());
        response.setFirstName(person.getFirstName());
        response.setLastName(person.getLastName());
        response.setSecondLastName(person.getSecondLastName());
        response.setFullName(person.getFullName()); // Método dinámico de la entidad
        response.setBirthDate(person.getBirthDate());
        response.setGender(person.getGender());

        return response;
    }

    /**
     * Convierte el modelo de petición (PersonRequest) a una entidad de persistencia (Person).
     *
     * @param request Datos de entrada.
     * @return Entidad Person lista para ser guardada.
     */
    private Person mapToEntity(PersonRequest request) {
        Person person = new Person();

        person.setDni(request.getDni());
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setSecondLastName(request.getSecondLastName());
        person.setBirthDate(request.getBirthDate());
        person.setGender(request.getGender());

        return person;
    }
}