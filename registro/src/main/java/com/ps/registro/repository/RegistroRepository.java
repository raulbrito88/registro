package com.ps.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ps.registro.modelo.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
}
