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

import com.aws.cfkirbey.model.Alumno;
import com.aws.cfkirbey.service.AlumnoService;

@RestController // Metaprogramacion
public class AlumnoRest {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos() {
        return ResponseEntity.ok().body(alumnoService.getAlumnos());
    }

    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> obtenerAlumno(@PathVariable Integer id) {
        return ResponseEntity.ok(alumnoService.buscarAlumno(id));
    }

    @PostMapping("/alumnos")
    public ResponseEntity<Alumno> crearAlumno(@Valid @RequestBody Alumno alumno) throws URISyntaxException {
        Alumno alumnoCreado = alumnoService.crearAlumno(alumno);
        
        return ResponseEntity
            .created(new URI("/alumnos/" + alumno.getMatricula()))
            .body(alumnoCreado);
    }

    @PutMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> editarAlumno(@PathVariable Integer id, @Valid @RequestBody Alumno alumno) {
        Alumno alumnoEditado = alumnoService.editarAlumno(alumno, id);
        return ResponseEntity.status(200).body(alumnoEditado);
    }

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Integer id) {
        alumnoService.eliminarAlumno(id);
        return ResponseEntity.status(200).build();
    }


}