package com.aws.cfkirbey.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.cfkirbey.model.Alumno;
import com.aws.cfkirbey.service.AlumnoService;

@RestController // Metaprogramacion
@RequestMapping("/api")
public class AlumnoRest {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos() {
        return ResponseEntity.ok().body(alumnoService.getAlumnos());
    }

    @GetMapping("/alumnos/{matricula}")
    public ResponseEntity<Alumno> obtenerAlumno(@PathVariable String matricula) {
        return ResponseEntity.ok(alumnoService.buscarAlumno(matricula));
    }

    @PostMapping("/alumnos")
    public ResponseEntity<Alumno> crearAlumno(@Valid @RequestBody Alumno alumno) throws URISyntaxException {
        Alumno alumnoCreado = alumnoService.crearAlumno(alumno);
        
        return ResponseEntity
            .created(new URI("/alumnos/" + alumno.getMatricula()))
            .body(alumnoCreado);
    }

    @PutMapping("/alumnos/{matricula}") // PUT /alumnos/1001930
    public ResponseEntity<Alumno> editarAlumno(@PathVariable String matricula, @RequestBody Alumno alumno) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/alumnos/{matricula}") // DELETE /alumnos/1001930
    public ResponseEntity<Void> eliminarAlumno(@PathVariable String matricula) {
        return ResponseEntity.ok().build();
    }


}