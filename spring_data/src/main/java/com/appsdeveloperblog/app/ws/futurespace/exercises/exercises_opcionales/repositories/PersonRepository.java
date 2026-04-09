package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.repositories;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio de persistencia para la entidad Person.
 * Extiende de JpaRepository para obtener todas las operaciones CRUD básicas.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * Método de consulta derivado (Query Method) para buscar por DNI.
     * Spring Data JPA genera la consulta SQL automáticamente:
     * "SELECT * FROM persons_opcional WHERE dni = ?"
     *
     * @param dni El documento de identidad a buscar.
     * @return Un Optional que puede contener la persona o estar vacío si no existe.
     */
    Optional<Person> findByDni(String dni);
}