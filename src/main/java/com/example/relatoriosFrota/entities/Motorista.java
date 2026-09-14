package com.example.relatoriosFrota.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_motoristas")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Long cpf;

    private Long cnh;

    private Boolean ativo;

    public Motorista() {
    }

    public Motorista(Long id, String nome, Long cpf, Long cnh, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.ativo = ativo;
    }
}