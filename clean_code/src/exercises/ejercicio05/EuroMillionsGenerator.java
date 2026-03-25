package exercises.ejercicio05;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Clase encargada de la logica de negocio para generar combinaciones ganadoras.
 * Aplica principios de Clean Code como evitar numeros magicos y delegar responsabilidades.
 */
public class EuroMillionsGenerator {

    // Constantes para los numeros principales de la apuesta (evitamos Magic Numbers)
    private static final int MAX_MAIN_NUMBERS = 5;
    private static final int MAIN_NUMBER_LIMIT = 50;

    // Constantes para las estrellas de la apuesta
    private static final int MAX_STARS = 2;
    private static final int STAR_LIMIT = 12;

    private final Random random;

    /**
     * Constructor que inicializa la clase y el generador de numeros aleatorios.
     */
    public EuroMillionsGenerator() {
        this.random = new Random();
    }

    /**
     * Genera un boleto completo con sus respectivos numeros principales y estrellas.
     *
     * @return Un objeto EuroMillionsTicket que contiene la apuesta generada.
     */
    public EuroMillionsTicket generateTicket() {
        // Generamos los 5 numeros principales (del 1 al 50)
        Set<Integer> mainNumbers = generateUniqueNumbers(MAX_MAIN_NUMBERS, MAIN_NUMBER_LIMIT);

        // Generamos las 2 estrellas (del 1 al 12)
        Set<Integer> stars = generateUniqueNumbers(MAX_STARS, STAR_LIMIT);

        return new EuroMillionsTicket(mainNumbers, stars);
    }

    /**
     * Genera un conjunto de numeros aleatorios unicos.
     * Se utiliza TreeSet para garantizar que no haya duplicados y que esten ordenados de menor a mayor.
     *
     * @param count La cantidad total de numeros a generar.
     * @param limit El valor maximo (inclusivo) que puede tener cada numero generado.
     * @return Un conjunto (Set) ordenado de numeros enteros unicos.
     */
    private Set<Integer> generateUniqueNumbers(int count, int limit) {
        Set<Integer> numbers = new TreeSet<>();

        // El bucle se repite hasta que el conjunto alcance la cantidad necesaria de numeros unicos
        while (numbers.size() < count) {
            // nextInt(limit) devuelve un valor entre 0 y limit-1, por lo que sumamos 1
            numbers.add(random.nextInt(limit) + 1);
        }

        return numbers;
    }
}