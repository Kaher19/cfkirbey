package com.aws.cfkirbey.service;

import java.io.IOException;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aws.cfkirbey.exception.NotFoundException;
import com.aws.cfkirbey.model.Alumno;
import com.aws.cfkirbey.repository.AlumnoRepository;
import com.aws.cfkirbey.utils.S3FileStorage;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private S3FileStorage fStorage;

    public List<Alumno> getAlumnos() {
        List<Alumno> alumnoes = new LinkedList<>();
        alumnoRepository.findAll().iterator().forEachRemaining(alumnoes::add);
        return alumnoes;
    }

    public Alumno crearAlumno(Alumno alumno) {
        alumno = alumnoRepository.save(alumno);
        return alumno;
    }

    public Alumno editarAlumno(Integer id, Alumno requestedAlumno) {
        Optional<Alumno> foundAlumno = buscarAlumno(id);
        Alumno alumno = foundAlumno.get(); 
        alumno.setNombres(requestedAlumno.getNombres());
        alumno.setApellidos(requestedAlumno.getApellidos());
        alumno.setPromedio(requestedAlumno.getPromedio());
        alumno.setMatricula(requestedAlumno.getMatricula());
        alumnoRepository.save(alumno);
        return alumno;
    }
    
    public Alumno eliminarAlumno(Integer id) {
        Optional<Alumno> foundAlumno = buscarAlumno(id);
        Alumno alumno = foundAlumno.get();
        alumnoRepository.delete(alumno);
        return alumno;
    }

    public Optional<Alumno> buscarAlumno(Integer id) {
        if (!alumnoRepository.findById(id).isPresent())
            throw new NotFoundException("El alumno con id " +id+" no existe!");
        return alumnoRepository.findById(id);
    }

    public Alumno fotoPerfil(Integer id, MultipartFile fotoPerfil) throws IOException {
        Optional<Alumno> foundAlumno = this.buscarAlumno(id);
        Alumno alumno = foundAlumno.get();
        String ruta = "storage/profile_pictures/alumnos/"+alumno.getMatricula()+"/"+Instant.now()+"_"+fotoPerfil.getOriginalFilename();
        alumno.setFotoPerfilUrl(fStorage.uploadFileToBucket(ruta, fotoPerfil));
        return alumnoRepository.save(alumno);
    }
}