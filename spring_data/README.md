# Spring Data JPA - Persistencia, Consultas Avanzadas y Gestión de Personas

Este módulo contiene la implementación de la capa de persistencia para el sistema de gestión bibliotecaria y un sistema
integral de gestión de personas con arquitectura de tres capas y validaciones REST.

## Estructura del Módulo

El código se organiza siguiendo principios de **Clean Code** y el patrón de capas de Spring:

- **[Entidades](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/exercises_opcionales/entities/)**:
  Definición del
  modelo de datos con JPA (`Book`, `Author`, `Person`). La clase `Person` incluye validaciones Jakarta para integridad
  en base de datos.
- **[Modelos (DTOs)](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/exercises_opcionales/model/)**:
  Capa de desacoplamiento que incluye `PersonRequest` para validación de entrada y `PersonResponse` para formateo de
  salida (Ejercicio de Refactorización).
- **[Servicios](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/exercises_opcionales/service/)**:
  Capa de lógica de negocio que gestiona la transformación entre entidades y modelos, desacoplando los controladores de
  los repositorios.
- *
  *[Repositorios](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/exercises_opcionales/repositories/)
  **:
  Interfaces que extienden de `JpaRepository`, encargadas de la persistencia de datos en MySQL.
- *
  *[Controladores (API REST)](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/exercises_opcionales/controller/)
  **: Endpoints especializados para CRUD y consultas. Refactorizados para ser "delgados" y delegar la lógica al
  servicio.

## Implementación de Consultas (Query Engine)

Se han desarrollado diferentes estrategias para la recuperación de datos, destacando los siguientes componentes:

- **Consultas Personalizadas**: Uso de la anotación `@Query` para lógica JPQL específica. Ver ejemplo
  en [BookRepository.java](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej03_jpa/repositories/BookRepository.java).
- **Derivación de Consultas**: Implementación de **Query Methods** para filtros automáticos.
- **Consultas Multivariable**: Desarrollo avanzado de métodos con navegación de propiedades y operadores lógicos.

## Gestión de Personas y Arquitectura Limpia (Ejercicios Opcionales)

Se ha implementado un sistema robusto para la gestión de ciudadanos siguiendo estándares de arquitectura empresarial:

- **Desacoplamiento con DTOs**: Uso de objetos de transferencia para proteger la entidad de persistencia. La salida JSON
  está organizada mediante `@JsonPropertyOrder` para mayor legibilidad.
- **Validación Robusta**: Validación doble en `PersonRequest` y `Person` usando `@NotBlank`, `@Past`, `@Size` y
  `@Pattern` (Regex para DNI).
- **Manejo de Excepciones**:
  El [GlobalExceptionHandler.java](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/exercises_opcionales/exceptions/GlobalExceptionHandler.java)
  centraliza las respuestas 400 (Bad Request) y 404 (Not Found) con mensajes estructurados.

## Características Técnicas

- **Arquitectura de 3 Capas**: Controlador -> Servicio -> Repositorio.
- **Nomenclatura CamelCase**: Consistencia total con los estándares de Java.
- **Documentación JavaDoc**: Todas las firmas de los métodos están documentadas detallando su propósito, parámetros y
  autores.

## Visualización de Resultados

La aplicación permite verificar los resultados a través de dos vías:

1. **Consola del servidor**: Para filtros bibliotecarios y logs de auditoría de acciones.
2. **Postman**: Para la validación de la API REST de personas, visualización de DTOs ordenados y control de excepciones.

---
**Desarrollado por:** Susana Bitar