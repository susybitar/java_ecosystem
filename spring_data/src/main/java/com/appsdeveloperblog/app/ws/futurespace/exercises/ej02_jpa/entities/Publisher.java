package com.appsdeveloperblog.app.ws.futurespace.exercises.ej02_jpa.entities;

import jakarta.persistence.*;

/**
 * Entidad que representa la editorial de los libros.
 * Mapeada a la tabla 'publishers' en la base de datos.
 */
@Entity
@Table(name = "publishers")
public class Publisher {

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
     * Nombre comercial de la editorial.
     * Se marca como unique para evitar duplicados.
     */
    @Column(
            name = "publisher_name",
            nullable = false,
            unique = true
    )
    private String publisherName;

    /**
     * Razón social legal de la empresa.
     */
    @Column(
            name = "company_name",
            nullable = false
    )
    private String companyName;

    /**
     * Constructor vacío requerido por JPA/Hibernate.
     */
    public Publisher() {
    }

    /**
     * Constructor para inicializar una editorial con sus datos.
     * No se incluye el ID ya que es autoincremental por base de datos.
     *
     * @param publisherName Nombre comercial.
     * @param companyName   Razón social legal.
     */
    public Publisher(String publisherName, String companyName) {
        this.publisherName = publisherName;
        this.companyName = companyName;
    }

    // Getters and Setters

    /**
     * Obtiene el identificador único de la editorial.
     *
     * @return Long con el id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la editorial.
     *
     * @param id Identificador autogenerado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre comercial de la editorial.
     *
     * @return String con el nombre.
     */
    public String getPublisherName() {
        return publisherName;
    }

    /**
     * Define el nombre comercial de la editorial.
     *
     * @param publisherName Nombre de la editorial.
     */
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    /**
     * Obtiene la razón social de la empresa.
     *
     * @return String con la razón social.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Define la razón social de la empresa.
     *
     * @param companyName Razón social legal.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}