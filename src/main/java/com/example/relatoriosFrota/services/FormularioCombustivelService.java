package com.example.relatoriosFrota.services;


import com.example.relatoriosFrota.dto.JWTUserData;
import com.example.relatoriosFrota.dto.request.FormularioCombustivelRequest;
import com.example.relatoriosFrota.entities.FormularioCombustivel;
import com.example.relatoriosFrota.entities.Motorista;
import com.example.relatoriosFrota.entities.Veiculo;
import com.example.relatoriosFrota.repository.FormularioCombustivelRepository;
import com.example.relatoriosFrota.repository.MotoristaRepository;
import com.example.relatoriosFrota.repository.VeiculoRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularioCombustivelService {

    private final FormularioCombustivelRepository formularioCombustivelRepository;
    private final VeiculoRepository veiculoRepository;
    private final MotoristaRepository motoristaRepository;

    public FormularioCombustivelService(
            FormularioCombustivelRepository formularioCombustivelRepository,
            VeiculoRepository veiculoRepository,
            MotoristaRepository motoristaRepository
    ) {
        this.formularioCombustivelRepository = formularioCombustivelRepository;
        this.veiculoRepository = veiculoRepository;
        this.motoristaRepository = motoristaRepository;
    }

    public FormularioCombustivel salvar(
            FormularioCombustivelRequest request
    ) {

        Veiculo veiculo = veiculoRepository.findById(request.veiculoId())
                .orElseThrow(() ->
                        new RuntimeException("Veículo não encontrado")
                );

        Motorista motorista = motoristaRepository.findById(request.motoristaId())
                .orElseThrow(() ->
                        new RuntimeException("Motorista não encontrado")
                );

        if (!Boolean.TRUE.equals(motorista.getAtivo())) {
            throw new RuntimeException(
                    "Não é possível lançar uma despesa para um motorista inativo"
            );
        }

        FormularioCombustivel formulario =
                new FormularioCombustivel();

        preencher(formulario, request, veiculo, motorista);

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        if (authentication != null &&
                authentication.getPrincipal() instanceof JWTUserData userData) {

            formulario.setUsuario(userData.name());
        }

        return formularioCombustivelRepository.save(formulario);
    }

    public FormularioCombustivel atualizar(
            Long id,
            FormularioCombustivelRequest request
    ) {

        FormularioCombustivel formulario =
                formularioCombustivelRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Abastecimento não encontrado"
                                )
                        );

        Veiculo veiculo =
                veiculoRepository.findById(request.veiculoId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Veículo não encontrado"
                                )
                        );

        Motorista motorista =
                motoristaRepository.findById(request.motoristaId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Motorista não encontrado"
                                )
                        );

        /*
         * Permitimos editar um lançamento antigo que tenha
         * um motorista que hoje esteja inativo.
         *
         * O bloqueio é somente para novos lançamentos.
         */
        preencher(formulario, request, veiculo, motorista);

        return formularioCombustivelRepository.save(formulario);
    }

    private void preencher(
            FormularioCombustivel formulario,
            FormularioCombustivelRequest request,
            Veiculo veiculo,
            Motorista motorista
    ) {

        formulario.setVeiculo(veiculo);
        formulario.setMotorista(motorista);
        formulario.setDespesa(request.despesa());
        formulario.setData(request.data());
        formulario.setNovoKm(request.novoKm());
        formulario.setValorUnitario(request.valorUnitario());
        formulario.setValorTotal(request.valorTotal());
        formulario.setQuantLitro(request.quantLitro());
        formulario.setObservacao(request.observacao());
    }

    public List<FormularioCombustivel> listarTodos() {
        return formularioCombustivelRepository.findAll();
    }

    public FormularioCombustivel buscarPorId(Long id) {
        return formularioCombustivelRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Abastecimento não encontrado"
                        )
                );
    }

    public void deletar(Long id) {
        formularioCombustivelRepository.deleteById(id);
    }
}