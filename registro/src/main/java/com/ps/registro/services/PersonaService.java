package com.ps.registro.services;

import com.ps.registro.modelo.Persona;
import com.ps.registro.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Transactional()
    @Override
    public Persona guardar(Persona persona) throws Exception {

        if (persona.getId() <= 0) {
            throw new Exception("El empleado no puede tener números menores o iguales a 0");
        }
        if (persona.getCorreo() == null || persona.getCorreo().isEmpty()) {
            throw new Exception("El usuario no tiene correo");
        }
        if (persona.getIdentificacion() == null || persona.getIdentificacion().isEmpty()) {
            throw new Exception("El usuario no tiene identificación");
        }
        if (persona.getNombres() == null || persona.getNombres().isEmpty()) {
            throw new Exception("El usuario no tiene nombres");
        }
        if (persona.getApellidos() == null || persona.getApellidos().isEmpty()) {
            throw new Exception("El usuario no tiene apellidos");
        }

        return personaRepository.save(persona);
    }

    @Override
    public Persona consultar(Long id) throws Exception {

        if (id == null || id <= 0) {
            throw new Exception("El id enviado no es válido");
        }

        return personaRepository.findById(id).orElseThrow(() -> new Exception("La persona no existe"));
    }

    @Override
    @Transactional()
    public Persona actualizar(Persona persona) throws Exception {

        Persona resultado = consultar(persona.getId());

        if (persona.getCorreo() != null && !persona.getCorreo().isEmpty()) {
            resultado.setCorreo(persona.getCorreo());
        }

        if (persona.getNombres() != null && !persona.getNombres().isEmpty()) {
            resultado.setNombres(persona.getNombres());
        }

        if (persona.getApellidos() != null && !persona.getApellidos().isEmpty()) {
            resultado.setApellidos(persona.getApellidos());
        }

        if (persona.getId() != null && persona.getId() < 0) {
            throw new Exception("La edad no puede ser negativa");
        }

        return personaRepository.save(resultado);
    }
}
