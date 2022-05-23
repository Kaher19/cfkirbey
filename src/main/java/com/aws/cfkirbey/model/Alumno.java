package com.aws.cfkirbey.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "alumnos")
public class Alumno  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty(message = "La matricula debe contener un valor no vacío.")
    @Length(min=5, message = "La matricula debe contener mas de 5 caracteres")
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

    @Column(name = "foto_perfil")
    private String fotoPerfilUrl;

    public Alumno() {}

    public Alumno(Integer id, String matricula, String nombres, String apellidos, Double promedio, String fotoPerfilUrl) {
        this.id = id;
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.promedio = promedio;
        this.fotoPerfilUrl = fotoPerfilUrl;
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

    public String getFotoPerfilUrl(){
        return this.fotoPerfilUrl;
    }
    
    public void setFotoPerfilUrl(String fotoPerfilUrl){
        this.fotoPerfilUrl = fotoPerfilUrl;
    }

    @Override
    public String toString() {
        return "";
    }

}
