package com.ps.registro.services.impl;

import com.ps.registro.services.IRegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.registro.modelo.Registro;
import com.ps.registro.repository.RegistroRepository;

@Service
public class RegistroServiceImpl implements IRegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    @Override
    public Registro guardar(Registro registro) throws Exception {
        return registroRepository.save(registro);
    }

    @Override
    public Registro consultar(int id) throws Exception {
        return registroRepository.findById(id).orElse(null);
    }

    @Override
    public Registro actualizar(Registro registro) throws Exception {
        return registroRepository.save(registro);
    }

    @Override
    public void borrar(int id) throws Exception {
        registroRepository.deleteById(id);
    }
}
