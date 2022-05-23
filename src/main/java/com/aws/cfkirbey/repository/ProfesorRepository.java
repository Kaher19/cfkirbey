package com.aws.cfkirbey.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.aws.cfkirbey.model.Profesor;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Integer> {
    
    public Optional<Profesor> findByNombres(String nombres);

    public Optional<Profesor> findByNumeroEmpleado(String numeroEmpleado);

    /* public Optional<Profesor> findByEmail(String email); */

}