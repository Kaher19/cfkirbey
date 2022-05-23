package com.aws.cfkirbey.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "profesores")
public class Profesor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Min(value = 1, message = "El id debe ser numérico y mayor a 1")
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotEmpty(message = "El numero de empleado debe contener un valor no vacío.")
    @Length(min=5, message = "El numero de empleado debe contener mas de 5 caracteres")
    @Column(name = "numero_empleado")
    private String numeroEmpleado;
    
    @NotEmpty
    @Length(min=2, max=255, message = "El nombre debe contener de 2 a 255 caracteres")
    private String nombres;

    @NotEmpty
    @Length(min=2, max=255, message = "El apellido debe contener de 2 a 255 caracteres")
    private String apellidos;
    
    @Column(name = "horas_clase")
    private Integer horasClase;

    public Profesor() {}

    public Profesor(Integer id, String numeroEmpleado, String nombres, String apellidos, Integer horasClase) {
        this.id = id;
        this.numeroEmpleado = numeroEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horasClase = horasClase;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroEmpleado() {
        return this.numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
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
    
    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }

    @Override
    public String toString() {
        return "";
    }

}
