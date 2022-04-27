package com.aws.cfkirbey.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aws.cfkirbey.model.Profesor;
import com.aws.cfkirbey.service.ProfesorService;

@RestController // Metaprogramacion
public class ProfesorRest {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/profesores")
    public ResponseEntity<List<Profesor>> getProfesors() {
        return ResponseEntity.ok().body(profesorService.getProfesores());
    }

    @GetMapping("/profesores/{id}")
    public ResponseEntity<Profesor> obtenerProfesor(@PathVariable Integer id) {
        return ResponseEntity.ok(profesorService.buscarProfesor(id));
    }

    @PostMapping("/profesores")
    public ResponseEntity<Profesor> crearProfesor(@Valid @RequestBody Profesor profesor) throws URISyntaxException {
        Profesor profesorCreado = profesorService.crearProfesor(profesor);
        
        return ResponseEntity
            .created(new URI("/profesores/" + profesor.getNumeroEmpleado()))
            .body(profesorCreado);
    }

    @PutMapping("/profesores/{id}")
    public ResponseEntity<Profesor> editarProfesor(@PathVariable Integer id, @Valid @RequestBody Profesor profesor) {
        Profesor profesorEditado = profesorService.editarProfesor(profesor, id);
        return ResponseEntity.status(200).body(profesorEditado);
    }

    @DeleteMapping("/profesores/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Integer id) {
        profesorService.eliminarProfesor(id);
        return ResponseEntity.status(200).build();
    }


}