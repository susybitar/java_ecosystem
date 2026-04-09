package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

/**
 * Modelo de respuesta para la exposición de datos de personas.
 * Utiliza @JsonPropertyOrder para garantizar que el JSON de salida mantenga
 * un orden lógico y profesional.
 */
@JsonPropertyOrder({"id", "dni", "firstName", "lastName", "secondLastName", "fullName", "birthDate", "gender"})
public class PersonResponse {

    private Long id;
    private String dni;
    private String firstName;
    private String lastName;
    private String secondLastName;
    private String fullName;
    private LocalDate birthDate;
    private String gender;

    // --- Getters y Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}