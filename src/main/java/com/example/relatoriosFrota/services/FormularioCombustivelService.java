package com.example.relatoriosFrota.services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.relatoriosFrota.dto.request.FormularioCombustivelRequest;
import com.example.relatoriosFrota.dto.JWTUserData;
import com.example.relatoriosFrota.entities.FormularioCombustivel;
import com.example.relatoriosFrota.entities.Veiculo;
import com.example.relatoriosFrota.repository.FormularioCombustivelRepository;
import com.example.relatoriosFrota.repository.VeiculoRepository;

@Service
public class FormularioCombustivelService {

    private final FormularioCombustivelRepository formularioCombustivelRepository;
    private final VeiculoRepository veiculoRepository;

    public FormularioCombustivelService(
            FormularioCombustivelRepository formularioCombustivelRepository,
            VeiculoRepository veiculoRepository
    ) {
        this.formularioCombustivelRepository = formularioCombustivelRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public FormularioCombustivel salvar(
            FormularioCombustivelRequest request
    ) {

        Veiculo veiculo = veiculoRepository.findById(request.veiculoId())
                .orElseThrow(() ->
                        new RuntimeException("Veículo não encontrado")
                );

        FormularioCombustivel formulario =
                new FormularioCombustivel();

        formulario.setVeiculo(veiculo);
        formulario.setDespesa(request.despesa());
        formulario.setData(request.data());
        formulario.setNovoKm(request.novoKm());
        formulario.setValorUnitario(request.valorUnitario());
        formulario.setValorTotal(request.valorTotal());
        formulario.setQuantLitro(request.quantLitro());
        formulario.setObservacao(request.observacao());

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        if (authentication != null
                && authentication.getPrincipal() instanceof JWTUserData userData) {

            formulario.setUsuario(userData.name());
        }

        return formularioCombustivelRepository.save(formulario);
    }

    public List<FormularioCombustivel> listarTodos() {
        return formularioCombustivelRepository.findAll();
    }

    public FormularioCombustivel buscarPorId(Long id) {
        return formularioCombustivelRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Abastecimento não encontrado")
                );
    }

    public void deletar(Long id) {
        formularioCombustivelRepository.deleteById(id);
    }
}