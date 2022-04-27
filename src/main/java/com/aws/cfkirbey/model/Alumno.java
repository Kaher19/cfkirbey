package com.aws.cfkirbey.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class Alumno {

    @Min(value = 1, message = "El id debe ser numérico y mayor a 1")
    private Integer id;
    
    @NotEmpty(message = "La matricula debe contener un valor no vacío.")
    @Length(min=9, max=9, message = "La matricula debe contener 9 caracteres")
    private String matricula;
    
    @NotEmpty
    @Length(min=2, max=255, message = "El nombre debe contener de 2 a 255 caracteres")
    private String nombres;

    @NotEmpty
    @Length(min=2, max=255, message = "El apellido debe contener de 2 a 255 caracteres")
    private String apellidos;
    
    @DecimalMax("100.0")
    @DecimalMin("0.0")
    private Double promedio;

    public Alumno() {}

    public Alumno(Integer id, String matricula, String nombres, String apellidos, Double promedio) {
        this.id = id;
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.promedio = promedio;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "";
    }

}
