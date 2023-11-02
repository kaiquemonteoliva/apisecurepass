package com.securepass.apisecurepass.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


public record TipoUsuarioDto(
            @NotBlank String tipo

    ) {
    }

