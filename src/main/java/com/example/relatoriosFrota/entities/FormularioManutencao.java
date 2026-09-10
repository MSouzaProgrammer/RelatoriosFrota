package com.example.relatoriosFrota.entities;

import java.time.LocalDate;

import com.example.relatoriosFrota.enuns.Despesa;
import com.example.relatoriosFrota.enuns.ManutencaoTipos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tb_manutencao")
public class FormularioManutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDaManutencao;

    @ManyToOne
    private Veiculo veiculo;

    private Despesa despesa;

    private LocalDate data;

    private ManutencaoTipos manutencaoTipos;

    private Long novoKm;

    private Long valorUnitario;

    private Long valorTotal;

    private String observacao;

    private String usuario;

    public FormularioManutencao() {
    }

    public FormularioManutencao(
            Long id,
            String nomeDaManutencao,
            Veiculo veiculo,
            Despesa despesa,
            LocalDate data,
            ManutencaoTipos manutencaoTipos,
            Long novoKm,
            Long valorUnitario,
            Long valorTotal,
            String observacao
    ) {
        this.id = id;
        this.nomeDaManutencao = nomeDaManutencao;
        this.veiculo = veiculo;
        this.despesa = despesa;
        this.data = data;
        this.manutencaoTipos = manutencaoTipos;
        this.novoKm = novoKm;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
    }
}