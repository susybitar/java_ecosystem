# Java Ecosystem: Clean Code & Spring Suite

Este repositorio centraliza mi progresión técnica en el ecosistema Java, desde la aplicación de estándares de calidad de
software hasta el desarrollo de aplicaciones empresariales.

---

## Módulos del Repositorio

### [Clean Code & Software Design](clean_code/)

Enfoque en la escritura de código legible, mantenible y robusto siguiendo los principios SOLID.

* **Destacado:** [Mastermind Engine](clean_code/src/exercises/ejercicio06/) - Implementación de un motor de juego con
  arquitectura desacoplada y lógica inmutable.

### [Spring Framework](spring_framework/)

Desarrollo de aplicaciones utilizando el core de Spring.

* Inyección de dependencias (DI) e Inversión de Control (IoC).
* Gestión de contextos y configuración de Beans.

### [Spring Data](spring_data/)

Persistencia de datos, repositorios JPA y gestión de bases de datos relacionales.

* **Arquitectura de 3 Capas**: Implementación de un flujo desacoplado (Controller -> Service -> Repository) para una
  mayor mantenibilidad.
* **Desacoplamiento con DTOs**: Uso de modelos de petición (`Request`) y respuesta (`Response`) para proteger las
  entidades JPA y personalizar los contratos de la API.
* **JPA Query Engine**: Desarrollo de repositorios avanzados utilizando Query Methods y @Query para consultas
  personalizadas.
* **Validación y Control de Errores**: Implementación de API REST con validaciones Jakarta (Bean Validation) tanto en
  DTOs como en entidades, y manejo global de excepciones (`@RestControllerAdvice`) para respuestas HTTP 400 y 404.
* **Optimización de Respuesta**: Uso de `@JsonPropertyOrder` para garantizar una salida JSON profesional y ordenada.
* Carga dinámica de catálogos mediante CommandLineRunner para inicialización de entornos.

---

## Stack Tecnológico

* **Lenguaje:** Java SE 17+
* **Frameworks:** Spring Boot, Spring Data JPA
* **Pruebas de API:** Postman (Colecciones de integración y validación)
* **Herramientas:** Maven / Gradle, Git
* **Metodologías:** Clean Code, Refactoring, OOP avanzada.

---
**Desarrollado por:** Susana Bitar