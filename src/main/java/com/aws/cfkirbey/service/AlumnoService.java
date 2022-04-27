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
        alumnos.add(new Alumno(1 ,"13001777", "Kirbey", "Apellidos", 84.5));
    }
    
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public Alumno crearAlumno(Alumno alumno) {
        alumnos.add(alumno);
        return alumno;
    }

    public Alumno editarAlumno(Alumno alumno, Integer id) {
        Alumno foundAlumno = buscarAlumno(id);
        int indice = alumnos.indexOf(foundAlumno);
        foundAlumno.setId(alumno.getId());
        foundAlumno.setNombres(alumno.getNombres());
        foundAlumno.setApellidos(alumno.getApellidos());
        foundAlumno.setPromedio(alumno.getPromedio());
        foundAlumno.setMatricula(alumno.getMatricula());
        alumnos.set(indice, foundAlumno);
        return foundAlumno;
    }
    
    public Alumno eliminarAlumno(Integer id) {
        Alumno foundAlumno = buscarAlumno(id);
        alumnos.remove(foundAlumno);
        return foundAlumno;
    }

    public Alumno buscarAlumno(Integer id) {
        
        Optional<Alumno> alumnoOptional = alumnos.stream()
                .filter(alumno -> alumno.getId().equals(id))
                .findFirst();

        if (!alumnoOptional.isPresent()) {
            throw new NotFoundException();
        }

        return alumnoOptional.get();
    }
}