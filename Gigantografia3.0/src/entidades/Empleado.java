package entidades;

import java.util.Objects;

public class Empleado {
    private int empleadoID;
    private String nombreEmpleado;
    private String cargo;
    private double salario;
    private boolean activo;

    public Empleado() {
    }

    public Empleado(int empleadoID, String nombreEmpleado, String cargo, double salario, boolean activo) {
        this.empleadoID = empleadoID;
        this.nombreEmpleado = nombreEmpleado;
        this.cargo = cargo;
        this.salario = salario;
        this.activo = activo;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "empleadoID=" + empleadoID +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", activo=" + activo +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleadoID, nombreEmpleado, cargo, salario, activo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return empleadoID == empleado.empleadoID &&
                Double.compare(empleado.salario, salario) == 0 &&
                activo == empleado.activo &&
                Objects.equals(nombreEmpleado, empleado.nombreEmpleado) &&
                Objects.equals(cargo, empleado.cargo);
    }
}
