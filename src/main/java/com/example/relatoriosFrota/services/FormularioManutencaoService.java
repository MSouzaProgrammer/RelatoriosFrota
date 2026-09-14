package com.example.relatoriosFrota.services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.relatoriosFrota.dto.JWTUserData;
import com.example.relatoriosFrota.dto.request.FormularioManutencaoRequest;
import com.example.relatoriosFrota.entities.FormularioManutencao;
import com.example.relatoriosFrota.entities.Motorista;
import com.example.relatoriosFrota.entities.Veiculo;
import com.example.relatoriosFrota.repository.ManutencaoRepository;
import com.example.relatoriosFrota.repository.MotoristaRepository;
import com.example.relatoriosFrota.repository.VeiculoRepository;

@Service
public class FormularioManutencaoService {

    private final ManutencaoRepository manutencaoRepository;
    private final VeiculoRepository veiculoRepository;
    private final MotoristaRepository motoristaRepository;

    public FormularioManutencaoService(
            ManutencaoRepository manutencaoRepository,
            VeiculoRepository veiculoRepository,
            MotoristaRepository motoristaRepository
    ) {
        this.manutencaoRepository = manutencaoRepository;
        this.veiculoRepository = veiculoRepository;
        this.motoristaRepository = motoristaRepository;
    }

    public FormularioManutencao salvar(
            FormularioManutencaoRequest request
    ) {

        Veiculo veiculo = buscarVeiculo(request.veiculoId());
        Motorista motorista = buscarMotorista(request.motoristaId());

        FormularioManutencao manutencao =
                new FormularioManutencao();

        preencherDados(
                manutencao,
                request,
                veiculo,
                motorista
        );

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        if (
                authentication != null &&
                authentication.getPrincipal()
                        instanceof JWTUserData userData
        ) {
            manutencao.setUsuario(userData.name());
        }

        return manutencaoRepository.save(manutencao);
    }

    public FormularioManutencao atualizar(
            Long id,
            FormularioManutencaoRequest request
    ) {

        FormularioManutencao manutencao =
                buscarPorId(id);

        Veiculo veiculo =
                buscarVeiculo(request.veiculoId());

        Motorista motorista =
                buscarMotorista(request.motoristaId());

        String usuarioAnterior =
                manutencao.getUsuario();

        preencherDados(
                manutencao,
                request,
                veiculo,
                motorista
        );

        manutencao.setUsuario(usuarioAnterior);

        return manutencaoRepository.save(manutencao);
    }

    private void preencherDados(
            FormularioManutencao manutencao,
            FormularioManutencaoRequest request,
            Veiculo veiculo,
            Motorista motorista
    ) {

        manutencao.setNomeDaManutencao(
                request.nomeDaManutencao()
        );

        manutencao.setVeiculo(
                veiculo
        );

        manutencao.setMotorista(
                motorista
        );

        manutencao.setDespesa(
                request.despesa()
        );

        manutencao.setData(
                request.data()
        );

        manutencao.setManutencaoTipos(
                request.manutencaoTipos()
        );

        manutencao.setNovoKm(
                request.novoKm()
        );

        manutencao.setValorUnitario(
                request.valorUnitario()
        );

        manutencao.setValorTotal(
                request.valorTotal()
        );

        manutencao.setObservacao(
                request.observacao()
        );
    }

    private Veiculo buscarVeiculo(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Veículo não encontrado"
                        )
                );
    }

    private Motorista buscarMotorista(Long id) {
        return motoristaRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Motorista não encontrado"
                        )
                );
    }

    public List<FormularioManutencao> listarTodos() {
        return manutencaoRepository.findAll();
    }

    public FormularioManutencao buscarPorId(Long id) {
        return manutencaoRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Manutenção não encontrada"
                        )
                );
    }

    public void deletar(Long id) {
        manutencaoRepository.deleteById(id);
    }
}