package com.securepass.apisecurepass.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;





    public record TipoUsuarioDto(
            @NotBlank @Nome (message = "O email deve estar em um formato válido") String nome,
            @NotBlank String email,
            @NotBlank String senha,
            String endereco,
            String cep,
            String tipo_usuario,
            MultipartFile imagem
    ) {
    }

