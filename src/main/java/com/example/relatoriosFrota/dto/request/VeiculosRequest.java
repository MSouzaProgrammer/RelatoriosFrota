package com.example.relatoriosFrota.dto.request;

import com.example.relatoriosFrota.entities.Motorista;
import com.example.relatoriosFrota.enuns.FIliais;
import com.example.relatoriosFrota.enuns.Marca;
import com.example.relatoriosFrota.enuns.ModelosVeiculos;

public record VeiculosRequest(
    String placa,
    Marca marca,
    ModelosVeiculos modelosVeiculos,
    Long ano,
    FIliais filial,
    Motorista motorista
) {}
