package com.aws.cfkirbey.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aws.cfkirbey.exception.NotFoundException;
import com.aws.cfkirbey.model.Alumno;

@Service
public class AlumnoService {

    private List<Alumno> alumnos = new LinkedList<>();

    {
        alumnos.add(new Alumno("13001777", "Kirbey Garcia", "a13001777@alumnos.uady.mx"));
    }
    
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public Alumno crearAlumno(Alumno alumno) {
        alumnos.add(alumno);
        return alumno;
    }

    public Alumno buscarAlumno(String matricula) {
        
        Optional<Alumno> alumnoOptional = alumnos.stream()
                .filter(student -> student.getMatricula().equals(matricula))
                .findFirst();

        if (!alumnoOptional.isPresent()) {
            throw new NotFoundException();
        }

        return alumnoOptional.get();
    }
}