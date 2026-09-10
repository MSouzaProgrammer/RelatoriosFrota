package com.example.relatoriosFrota.services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.relatoriosFrota.dto.JWTUserData;
import com.example.relatoriosFrota.dto.request.FormularioManutencaoRequest;
import com.example.relatoriosFrota.entities.FormularioManutencao;
import com.example.relatoriosFrota.entities.Veiculo;
import com.example.relatoriosFrota.repository.ManutencaoRepository;
import com.example.relatoriosFrota.repository.VeiculoRepository;

@Service
public class FormularioManutencaoService {

    private final ManutencaoRepository manutencaoRepository;
    private final VeiculoRepository veiculoRepository;

    public FormularioManutencaoService(
            ManutencaoRepository manutencaoRepository,
            VeiculoRepository veiculoRepository
    ) {
        this.manutencaoRepository = manutencaoRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public FormularioManutencao salvar(
            FormularioManutencaoRequest request
    ) {

        Veiculo veiculo = veiculoRepository.findById(request.veiculoId())
                .orElseThrow(() ->
                        new RuntimeException("Veículo não encontrado")
                );

        FormularioManutencao manutencao =
                new FormularioManutencao();

        manutencao.setNomeDaManutencao(request.nomeDaManutencao());
        manutencao.setVeiculo(veiculo);
        manutencao.setDespesa(request.despesa());
        manutencao.setData(request.data());
        manutencao.setManutencaoTipos(request.manutencaoTipos());
        manutencao.setNovoKm(request.novoKm());
        manutencao.setValorUnitario(request.valorUnitario());
        manutencao.setValorTotal(request.valorTotal());
        manutencao.setObservacao(request.observacao());

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        if (authentication != null
                && authentication.getPrincipal() instanceof JWTUserData userData) {

            manutencao.setUsuario(userData.name());
        }

        return manutencaoRepository.save(manutencao);
    }

    public List<FormularioManutencao> listarTodos() {
        return manutencaoRepository.findAll();
    }

    public FormularioManutencao buscarPorId(Long id) {
        return manutencaoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Manutenção não encontrada")
                );
    }

    public void deletar(Long id) {
        manutencaoRepository.deleteById(id);
    }
}