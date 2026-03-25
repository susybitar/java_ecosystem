package exercises.ejercicio05;

/**
 * Clase encargada exclusivamente de la visualizacion de los boletos.
 * Cumple con el Principio de Responsabilidad Unica al separar la presentacion visual de la logica matematica.
 */
public class TicketPrinter {

    /**
     * Imprime el boleto de Euromillones por la salida estandar (consola).
     *
     * @param ticket El objeto que contiene los datos de la apuesta a imprimir.
     */
    public void print(EuroMillionsTicket ticket) {
        System.out.println("--- Tu Apuesta de Euromillones ---");
        System.out.println("Numeros principales : " + ticket.getMainNumbers());
        System.out.println("Estrellas           : " + ticket.getStars());
        System.out.println("----------------------------------");
        System.out.println("¡Mucha suerte!");
    }
}