package com.securepass.apisecurepass.repositories;

import com.securepass.apisecurepass.models.TipoUsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioModel, UUID> {

    Optional<TipoUsuarioModel> findById(UUID id);
    TipoUsuarioModel findByTipo(String tipo);

}