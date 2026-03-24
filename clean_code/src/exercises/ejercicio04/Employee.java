package exercises.ejercicio04;

/**
 * Representa a un empleado y gestiona su informacion financiera.
 * Se ha refactorizado moviendo el calculo del salario mensual aqui
 * para evitar el "Feature Envy".
 */
public class Employee {
    private double yearlySalary;
    private double awards;

    /**
     * Constructor para inicializar un empleado con su salario y premios.
     * @param yearlySalary Salario total al año.
     * @param awards Bonificaciones o premios anuales.
     */
    public Employee(double yearlySalary, double awards) {
        this.yearlySalary = yearlySalary;
        this.awards = awards;
    }

    /**
     * Calcula el salario mensual promediando el salario anual y los premios.
     * @return El salario mensual resultante.
     */
    public double getMonthlySalary() {
        // El calculo se realiza internamente usando sus propios atributos.
        return (yearlySalary + awards) / 12;
    }
}