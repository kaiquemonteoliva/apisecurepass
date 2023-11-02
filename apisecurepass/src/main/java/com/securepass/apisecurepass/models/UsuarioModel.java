package com.securepass.apisecurepass.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "usuario_model")
public class UsuarioModel {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private Integer matricula;
    private String nome;
    private String area;
    private String email;


}