package com.example.relatoriosFrota.dto.request;

import java.time.LocalDate;

import com.example.relatoriosFrota.enuns.Despesa;

public record FormularioCombustivelRequest(
        Long veiculoId,
        Long motoristaId,
        Despesa despesa,
        LocalDate data,
        Long novoKm,
        Long valorUnitario,
        Long valorTotal,
        Long quantLitro,
        String observacao
) {
}