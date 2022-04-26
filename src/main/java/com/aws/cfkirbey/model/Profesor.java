package com.aws.cfkirbey.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Profesor {
    
    // POJO: Plain Java Object
    // Validar aqui (opcional)
    
    @NotEmpty(message = "La matricula no puede ser vacía")
    private String matricula; // NO vacia - null or ""
    
    @NotEmpty
    private String nombre; // No vacio - null or ""

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    private String correo;

    public Profesor() {
    }

    public Profesor(String matricula, String nombre) {
        this.matricula = matricula;
        this.nombre = nombre;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor matricula(String matricula) {
        setMatricula(matricula);
        return this;
    }

    public Profesor nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "{" +
            " matricula='" + getMatricula() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }

}
