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

    @PostMapping (consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> cadastrarUsuario(@ModelAttribute @Valid TipoUsuarioDto tipoUsuarioDto){
        if (tipoUsuarioRepository.findByNome(tipoUsuarioDto.nome()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esse nome ja esta cadastrado");
        }

        TipoUsuarioModel usuario = new TipoUsuarioModel();
        BeanUtils.copyProperties(TipoUsuarioDto, usuario);

        String urlImagem;

        try {
            urlImagem = fileUploadService.FazerUpload(tipoUsuarioDto.imagem());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        usuario.setUrl_img(urlImagem);

        return ResponseEntity.status(HttpStatus.CREATED).body(TipoUsuarioRepository.save(usuario));

    }
















}
