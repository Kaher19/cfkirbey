package com.aws.cfkirbey.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.aws.cfkirbey.model.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {
    
    public Optional<Alumno> findByNombres(String nombres);

    public Optional<Alumno> findByMatricula(String matricula);

}