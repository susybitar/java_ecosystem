package com.appsdeveloperblog.app.ws.futurespace.exercises.ej02_jpa.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Entidad que representa a los autores de los libros.
 * Mapeada a la tabla 'authors' en la base de datos.
 */
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    /**
     * Nombre del autor.
     */
    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    /**
     * Apellidos del autor.
     */
    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    /**
     * Fecha de nacimiento del autor.
     * Se utiliza LocalDate para gestionar únicamente la fecha (sin hora).
     */
    @Column(
            name = "birth_date",
            nullable = false
    )
    private LocalDate birthDate;

    /**
     * Constructor vacío requerido por JPA/Hibernate.
     */
    public Author() {
    }

    /**
     * Constructor para crear nuevos autores.
     * El ID se omite para que la base de datos lo asigne automáticamente.
     *
     * @param firstName Nombre.
     * @param lastName  Apellidos.
     * @param birthDate Fecha de nacimiento.
     */
    public Author(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    // Getters and Setters

    /**
     * Obtiene el identificador único del autor.
     *
     * @return Long con el id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del autor.
     *
     * @param id Identificador autogenerado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del autor.
     *
     * @return String con el nombre.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Define el nombre del autor.
     *
     * @param firstName Nombre del autor.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Obtiene los apellidos del autor.
     *
     * @return String con los apellidos.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Define los apellidos del autor.
     *
     * @param lastName Apellidos del autor.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Obtiene la fecha de nacimiento.
     *
     * @return LocalDate con la fecha.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Define la fecha de nacimiento.
     *
     * @param birthDate Fecha de nacimiento.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}