package com.appsdeveloperblog.app.ws.futurespace.exercises.ej02_jpa;

import jakarta.persistence.*;

/**
 * Entidad que representa la temática o categoría de los libros.
 * Mapeada a la tabla 'categories' en la base de datos.
 */
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id",
            updatable = false)
    private Long id;

    @Column(
            name = "category_name",
            nullable = false,
            unique = true // garantiza que no existan dos registros con el mismo nombre.

    )
    private String categoryName;

    /**
     * Constructor vacío requerido por JPA/Hibernate.
     */
    public Category() {
    }

    /**
     * Constructor para inicializar la categoría con su nombre.
     * No incluimos el ID porque MySQL lo genera automáticamente.
     */
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }


    // Getters and Setters

    /**
     * Obtiene el identificador único de la categoría.
     *
     * @return Long con el id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la categoría.
     *
     * @param id Identificador autogenerado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre descriptivo de la temática (ej. Novela, Historia).
     *
     * @return String con el nombre de la categoría.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Define el nombre de la categoría.
     *
     * @param categoryName Nombre de la temática.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}