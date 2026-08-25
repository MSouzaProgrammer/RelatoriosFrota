package com.example.relatoriosFrota.entities;

import java.util.List;

import com.example.relatoriosFrota.enuns.Marca;
import com.example.relatoriosFrota.enuns.ModelosVeiculos;

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
    private Long Km;
    
    public Veiculo() {
    }

    public Veiculo(Long id, String placa, ModelosVeiculos modelosVeiculos, Marca marca, Long ano) {
        this.id = id;
        this.placa = placa;
        this.modelosVeiculos = modelosVeiculos;
        this.marca = marca;
        this.ano = ano;
    }
}
