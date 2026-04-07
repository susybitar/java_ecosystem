package com.appsdeveloperblog.app.ws.futurespace.exercises.ej02_jpa.entities;

import jakarta.persistence.*;

/**
 * Entidad que representa un libro en el sistema.
 * Esta clase une las entidades Author, Publisher y Category.
 * Mapeada a la tabla 'books' en la base de datos.
 */
@Entity
@Table(name = "books")
public class Book {

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
     * Código ISBN único del libro.
     */
    @Column(
            name = "isbn",
            nullable = false,
            unique = true
    )
    private String isbn;

    /**
     * Título del libro.
     */
    @Column(
            name = "title",
            nullable = false
    )
    private String title;

    /**
     * Año de publicación del libro.
     */
    @Column(
            name = "publication_year",
            nullable = false
    )
    private Integer publicationYear;

    /**
     * Relación con el Autor del libro.
     */
    @ManyToOne
    @JoinColumn(
            name = "author_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private Author author;

    /**
     * Relación con la Editorial.
     */
    @ManyToOne
    @JoinColumn(
            name = "publisher_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private Publisher publisher;

    /**
     * Relación con la Categoría o Temática.
     */
    @ManyToOne
    @JoinColumn(
            name = "category_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private Category category;

    /**
     * Constructor vacío requerido por JPA/Hibernate.
     */
    public Book() {
    }

    /**
     * Constructor para inicializar un libro con todos sus datos y relaciones.
     *
     * @param isbn            Código ISBN.
     * @param title           Título del libro.
     * @param publicationYear Año de publicación.
     * @param author          Autor vinculado.
     * @param publisher       Editorial vinculada.
     * @param category        Categoría vinculada.
     */
    public Book(String isbn, String title, Integer publicationYear, Author author, Publisher publisher, Category category) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}