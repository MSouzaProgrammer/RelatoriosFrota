package com.example.relatoriosFrota.dto.request;

import java.time.LocalDate;

import com.example.relatoriosFrota.enuns.Despesa;
import com.example.relatoriosFrota.enuns.ManutencaoTipos;

public record FormularioManutencaoRequest(

        Long veiculoId,

        Long motoristaId,

        String nomeDaManutencao,

        Despesa despesa,

        LocalDate data,

        ManutencaoTipos manutencaoTipos,

        Long novoKm,

        Long valorUnitario,

        Long valorTotal,

        String observacao
) {
}