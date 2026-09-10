package com.example.relatoriosFrota.services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.relatoriosFrota.dto.JWTUserData;
import com.example.relatoriosFrota.dto.request.FormularioLavagemRequest;
import com.example.relatoriosFrota.entities.FormularioLavagem;
import com.example.relatoriosFrota.entities.Veiculo;
import com.example.relatoriosFrota.repository.LavagemRepository;
import com.example.relatoriosFrota.repository.VeiculoRepository;

@Service
public class FormularioLavagemService {

    private final LavagemRepository lavagemRepository;
    private final VeiculoRepository veiculoRepository;

    public FormularioLavagemService(
            LavagemRepository lavagemRepository,
            VeiculoRepository veiculoRepository
    ) {
        this.lavagemRepository = lavagemRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public FormularioLavagem salvar(
            FormularioLavagemRequest request
    ) {

        Veiculo veiculo = veiculoRepository.findById(request.veiculoId())
                .orElseThrow(() ->
                        new RuntimeException("Veículo não encontrado")
                );

        FormularioLavagem lavagem = new FormularioLavagem();

        lavagem.setVeiculo(veiculo);
        lavagem.setDespesa(request.despesa());
        lavagem.setData(request.data());
        lavagem.setNovoKm(request.novoKm());
        lavagem.setValorlavagem(request.valorlavagem());
        lavagem.setObservacao(request.observacao());

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        if (authentication != null
                && authentication.getPrincipal() instanceof JWTUserData userData) {

            lavagem.setUsuario(userData.name());
        }

        return lavagemRepository.save(lavagem);
    }

    public List<FormularioLavagem> listarTodos() {
        return lavagemRepository.findAll();
    }

    public FormularioLavagem buscarPorId(Long id) {
        return lavagemRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Lavagem não encontrada")
                );
    }

    public void deletar(Long id) {
        lavagemRepository.deleteById(id);
    }
}