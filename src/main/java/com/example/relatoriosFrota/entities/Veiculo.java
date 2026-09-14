package com.example.relatoriosFrota.entities;

import com.example.relatoriosFrota.enuns.Filial;
import com.example.relatoriosFrota.enuns.Marca;
import com.example.relatoriosFrota.enuns.ModelosVeiculos;
import com.example.relatoriosFrota.enuns.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    private ModelosVeiculos modelosVeiculos;

    private Marca marca;

    private Long ano;

    private Long km;

    private Filial filial;

    private Status status;

    public Veiculo() {
    }

    public Veiculo(
            Long id,
            String placa,
            ModelosVeiculos modelosVeiculos,
            Marca marca,
            Long ano,
            Long km,
            Filial filial,
            Status status
    ) {
        this.id = id;
        this.placa = placa;
        this.modelosVeiculos = modelosVeiculos;
        this.marca = marca;
        this.ano = ano;
        this.km = km;
        this.filial = filial;
        this.status = status;
    }
}