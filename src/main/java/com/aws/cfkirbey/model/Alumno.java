package com.aws.cfkirbey.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class Alumno {
    
    // POJO: Plain Java Object
    // Validar aqui (opcional)
    
    @NotEmpty(message = "La matricula debe contener un valor no vacío.")
    @Length(min=8, max=8, message = "La matricula debe contener 8 caracteres")
    private String matricula;
    
    @NotEmpty
    @Length(min=2, max=80, message = "El nombre debe contener de :min a :max caracteres")
    private String nombre;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    @NotEmpty(message = "El nombre debe contener un valor no vacío.")
    private String correo;

    public Alumno() {}

    public Alumno(String matricula, String nombre, String correo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "";
    }

}
