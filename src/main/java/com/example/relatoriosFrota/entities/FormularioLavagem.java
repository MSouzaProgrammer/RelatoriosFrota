package com.example.relatoriosFrota.entities;

import java.time.LocalDate;

import com.example.relatoriosFrota.enuns.Despesa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_lavagem")
@Getter
@Setter
public class FormularioLavagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Veiculo veiculo;

    private Despesa despesa;

    private LocalDate data;

    private Long novoKm;

    private Long valorlavagem;

    private String observacao;

    private String usuario;

    public FormularioLavagem() {
    }

    public FormularioLavagem(
            Long id,
            Veiculo veiculo,
            Despesa despesa,
            LocalDate data,
            Long novoKm,
            Long valorlavagem,
            String observacao
    ) {
        this.id = id;
        this.veiculo = veiculo;
        this.despesa = despesa;
        this.data = data;
        this.novoKm = novoKm;
        this.valorlavagem = valorlavagem;
        this.observacao = observacao;
    }
}