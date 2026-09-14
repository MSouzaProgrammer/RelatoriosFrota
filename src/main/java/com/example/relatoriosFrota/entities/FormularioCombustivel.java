package com.example.relatoriosFrota.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import com.example.relatoriosFrota.enuns.Despesa;

@Entity
@Table(name = "tb_combustivel")
@Getter 
@Setter
public class FormularioCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Veiculo veiculo;

    @ManyToOne
    private Motorista motorista;

    private Despesa despesa;

    private LocalDate data;

    private Long novoKm;

    private Long valorUnitario;

    private Long valorTotal;

    private Long quantLitro;

    private String observacao;

    private String usuario;

    public FormularioCombustivel() {
    }

    public FormularioCombustivel(
            Long id,
            Veiculo veiculo,
            Motorista motorista,
            Despesa despesa,
            LocalDate data,
            Long novoKm,
            Long valorUnitario,
            Long valorTotal,
            Long quantLitro,
            String observacao,
            String usuario
    ) {
        this.id = id;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.despesa = despesa;
        this.data = data;
        this.novoKm = novoKm;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.quantLitro = quantLitro;
        this.observacao = observacao;
        this.usuario = usuario;
    }
}