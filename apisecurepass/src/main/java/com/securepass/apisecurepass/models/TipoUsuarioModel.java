package com.securepass.apisecurepass.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_tipousuario")
public class TipoUsuarioModel {
    @Serial
    private static final  long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String tipo;

    public void setUrl_img(String urlImagem) {
    }
}