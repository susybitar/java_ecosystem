package exercises.ejercicio05;

/**
 * Punto de entrada principal de la aplicacion.
 * Actua como orquestador, instanciando los objetos necesarios y definiendo el flujo del programa.
 */
public class Main {

    /**
     * Metodo principal que ejecuta la generacion e impresion de la apuesta de Euromillones.
     * * @param args Argumentos de la linea de comandos (no se utilizan en esta implementacion).
     */
    public static void main(String[] args) {
        // 1. Instanciamos el generador que contiene la logica matematica
        EuroMillionsGenerator generator = new EuroMillionsGenerator();

        // 2. Generamos el boleto y lo guardamos en nuestro objeto de datos
        EuroMillionsTicket ticket = generator.generateTicket();

        // 3. Instanciamos la clase encargada de la vista para mostrar el resultado
        TicketPrinter printer = new TicketPrinter();
        printer.print(ticket);
    }
}