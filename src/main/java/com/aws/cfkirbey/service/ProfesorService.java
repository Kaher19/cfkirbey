package com.aws.cfkirbey.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aws.cfkirbey.exception.NotFoundException;
import com.aws.cfkirbey.model.Profesor;

@Service
public class ProfesorService {

    private List<Profesor> profesores = new LinkedList<>();

    {
        profesores.add(new Profesor(1 ,"09001777", "Eduardo", "Rodriguezx", 25));
    }
    
    public List<Profesor> getProfesores() {
        return profesores;
    }

    public Profesor crearProfesor(Profesor alumno) {
        profesores.add(alumno);
        return alumno;
    }

    public Profesor editarProfesor(Profesor alumno, Integer id) {
        Profesor foundProfesor = buscarProfesor(id);
        int indice = profesores.indexOf(foundProfesor);
        foundProfesor.setId(alumno.getId());
        foundProfesor.setNombres(alumno.getNombres());
        foundProfesor.setApellidos(alumno.getApellidos());
        foundProfesor.setHorasClase(alumno.getHorasClase());
        foundProfesor.setNumeroEmpleado(alumno.getNumeroEmpleado());
        profesores.set(indice, foundProfesor);
        return foundProfesor;
    }
    
    public Profesor eliminarProfesor(Integer id) {
        Profesor foundProfesor = buscarProfesor(id);
        profesores.remove(foundProfesor);
        return foundProfesor;
    }

    public Profesor buscarProfesor(Integer id) {
        
        Optional<Profesor> profesorOptional = profesores.stream()
                .filter(alumno -> alumno.getId().equals(id))
                .findFirst();

        if (!profesorOptional.isPresent()) {
            throw new NotFoundException();
        }

        return profesorOptional.get();
    }
}