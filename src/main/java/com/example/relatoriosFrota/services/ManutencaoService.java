package com.example.relatoriosFrota.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.relatoriosFrota.entities.FormularioManutencao;
import com.example.relatoriosFrota.repository.ManutencaoRepository;

@Service
public class ManutencaoService {

    private final ManutencaoRepository manutencaoRepository;

    public ManutencaoService(ManutencaoRepository manutencaoRepository) {
        this.manutencaoRepository = manutencaoRepository;
    }

    public FormularioManutencao salvar(FormularioManutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }

    public List<FormularioManutencao> listarTodos() {
        return manutencaoRepository.findAll();
    }

    public FormularioManutencao buscarPorId(Long id) {
        return manutencaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manutenção não encontrada"));
    }

    public void deletar(Long id) {
        manutencaoRepository.deleteById(id);
    }
}
