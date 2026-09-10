package com.example.relatoriosFrota.dto.request;

import java.time.LocalDate;

import com.example.relatoriosFrota.enuns.Despesa;

public record FormularioLavagemRequest(
        Long veiculoId,
        Despesa despesa,
        LocalDate data,
        Long novoKm,
        Long valorlavagem,
        String observacao
) {
}
