package com.securepass.apisecurepass.controllers;

import com.securepass.apisecurepass.dto.TipoUsuarioDto;
import com.securepass.apisecurepass.models.TipoUsuarioModel;
import com.securepass.apisecurepass.repositories.TipoUsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/tipousuario", produces = {"application/json"})
public class TipoUsuarioController {

    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping
    public ResponseEntity<List<TipoUsuarioModel>> listarTipoUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoUsuarioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarTipoUsuario(@RequestBody @Valid TipoUsuarioDto tipoUsuarioDto){
        if (tipoUsuarioRepository.findByTipo(tipoUsuarioDto.tipo()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esse tipo ja esta cadastrado");
        }

        TipoUsuarioModel tipo = new TipoUsuarioModel();

        BeanUtils.copyProperties(tipoUsuarioDto, tipo);




        return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuarioRepository.save(tipo));

    }
















}
