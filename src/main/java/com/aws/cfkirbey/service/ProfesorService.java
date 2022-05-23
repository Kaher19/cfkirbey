package com.aws.cfkirbey.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.cfkirbey.exception.NotFoundException;
import com.aws.cfkirbey.model.Profesor;
import com.aws.cfkirbey.repository.ProfesorRepository;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> getProfesores() {
        List<Profesor> profesores = new LinkedList<>();
        profesorRepository.findAll().iterator().forEachRemaining(profesores::add);
        return profesores;
    }

    public Profesor crearProfesor(Profesor profesor) {
        profesor = profesorRepository.save(profesor);
        return profesor;
    }

    public Profesor editarProfesor(Integer id, Profesor requestedProfesor) {
        Optional<Profesor> foundProfesor = buscarProfesor(id);
        Profesor profesor = foundProfesor.get(); 
        profesor.setNombres(requestedProfesor.getNombres());
        profesor.setApellidos(requestedProfesor.getApellidos());
        profesor.setHorasClase(requestedProfesor.getHorasClase());
        profesor.setNumeroEmpleado(requestedProfesor.getNumeroEmpleado());
        profesorRepository.save(profesor);
        return profesor;
    }
    
    public Profesor eliminarProfesor(Integer id) {
        Optional<Profesor> foundProfesor = buscarProfesor(id);
        Profesor profesor = foundProfesor.get(); 
        profesorRepository.delete(profesor);
        return profesor;
    }

    public Optional<Profesor> buscarProfesor(Integer id) {
        if (!profesorRepository.findById(id).isPresent())
            throw new NotFoundException("El profesor con id " +id+" no existe!");
        return profesorRepository.findById(id);
    }
}