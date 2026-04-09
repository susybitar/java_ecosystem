package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

/**
 * Modelo de petición para la captura de datos de personas.
 */
public class PersonRequest {

    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(regexp = "^[0-9]{8}[TRWAGMYFPDXBNJZSTQVHLCKE]$", message = "Formato de DNI no válido")
    private String dni;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String firstName;

    @NotBlank(message = "El primer apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El primer apellido debe tener entre 2 y 50 caracteres")
    private String lastName;

    @NotBlank(message = "El segundo apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El segundo apellido debe tener entre 2 y 50 caracteres")
    private String secondLastName;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    private LocalDate birthDate;

    @NotBlank(message = "El sexo es obligatorio")
    @Pattern(regexp = "^[HM]$", message = "El sexo debe ser 'H' (Hombre) o 'M' (Mujer)")
    private String gender;

    // Getters y Setters

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