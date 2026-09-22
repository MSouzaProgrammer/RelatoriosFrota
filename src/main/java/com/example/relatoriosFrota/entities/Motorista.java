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

    private String cpf;

    private String cnh;

    private Boolean ativo;

    public Motorista() {
    }

    public Motorista(Long id, String nome, String cpf, String cnh, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.ativo = ativo;
    }
}