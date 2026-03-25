package exercises.ejercicio05;

import java.util.Set;

/**
 * Representa un boleto de Euromillones.
 * Su unica responsabilidad es almacenar los datos de la apuesta (Data Class).
 */
public class EuroMillionsTicket {

    private final Set<Integer> mainNumbers;
    private final Set<Integer> stars;

    /**
     * Constructor para inicializar un boleto con sus numeros y estrellas.
     * * @param mainNumbers Conjunto de numeros principales.
     * @param stars Conjunto de estrellas.
     */
    public EuroMillionsTicket(Set<Integer> mainNumbers, Set<Integer> stars) {
        this.mainNumbers = mainNumbers;
        this.stars = stars;
    }

    /**
     * Obtiene los numeros principales del boleto.
     * * @return Un Set con los numeros principales.
     */
    public Set<Integer> getMainNumbers() {
        return mainNumbers;
    }

    /**
     * Obtiene las estrellas del boleto.
     * * @return Un Set con las estrellas.
     */
    public Set<Integer> getStars() {
        return stars;
    }
}