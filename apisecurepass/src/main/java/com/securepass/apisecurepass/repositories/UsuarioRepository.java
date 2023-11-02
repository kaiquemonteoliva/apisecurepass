package com.securepass.apisecurepass.repositories;

import com.securepass.apisecurepass.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {

    UsuarioModel findByNome(String nome);

    List<UsuarioModel> findall();
}