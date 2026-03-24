package exercises.ejercicio04;

/**
 * Clase encargada de procesar tareas relacionadas con los empleados.
 */
public class EmployeeProcessor {

    /**
     * Metodo que demuestra el uso del calculo de salario refactorizado.
     * @param employee El objeto empleado a procesar.
     */
    public void employeeMethod(Employee employee) {
        // Ahora el procesador no necesita conocer la formula del salario,
        // simplemente delega la responsabilidad al objeto Employee.
        double monthlySalary = employee.getMonthlySalary();

        System.out.println("El salario mensual calculado es: " + monthlySalary);
    }
}