package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.config;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.entities.Person;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Configuración para la inicialización masiva de datos en MySQL al arrancar la aplicación.
 * Prepara el entorno para el Ejercicio 3, cargando 10 registros que permitirán
 * probar las actualizaciones y búsquedas por DNI.
 */
@Configuration
public class InitializerData {

    /**
     * Bean que se ejecuta al iniciar Spring Boot para poblar la base de datos.
     * Se verifica primero si existen datos para no duplicar registros en cada reinicio.
     *
     * @param repository Repositorio de personas inyectado automáticamente por Spring.
     * @return CommandLineRunner con la lógica de inserción.
     */
    @Bean
    CommandLineRunner initDatabase(PersonRepository repository) {
        return args -> {
            // Solo procedemos a la carga si la tabla está vacía para mantener la integridad
            if (repository.count() == 0) {
                // Si la tabla esta vacía, insertamos los registros.
                List<Person> samplePeople = Arrays.asList(
                        new Person("12345678Z", "Susana", "Bitar", "Azevedo", LocalDate.of(1995, 11, 13), "M"),
                        new Person("10000000V", "Juan", "García", "Pérez", LocalDate.of(1980, 5, 20), "H"),
                        new Person("20000000B", "María", "López", "Gómez", LocalDate.of(1992, 8, 15), "M"),
                        new Person("30000000M", "Carlos", "Sánchez", "Ruiz", LocalDate.of(1975, 12, 10), "H"),
                        new Person("40000000E", "Elena", "Martínez", "Sanz", LocalDate.of(1988, 3, 25), "M"),
                        new Person("50000000Q", "Roberto", "Jiménez", "Díaz", LocalDate.of(2000, 1, 30), "H"),
                        new Person("60000000X", "Lucía", "Fernández", "Alonso", LocalDate.of(1997, 6, 12), "M"),
                        new Person("70000000G", "Andrés", "Castro", "Vila", LocalDate.of(1985, 9, 5), "H"),
                        new Person("80000000K", "Sofía", "Ortega", "Blanco", LocalDate.of(1993, 11, 22), "M"),
                        new Person("90000000S", "Diego", "Mendoza", "León", LocalDate.of(1982, 7, 18), "H")
                );

                // Guardamos todos los registros en una sola operación
                repository.saveAll(samplePeople);

                // Log de auditoria por consola
                System.out.println("--- EJERCICIO 3: CARGA INICIAL COMPLETADA ---");
                System.out.println("Se han insertado " + repository.count() + " registros en la tabla.");
            } else {
                System.out.println("La base de datos ya contiene registros. Saltando inicialización.");
            }
        }; // Se ha corregido el cierre del lambda
    }
}