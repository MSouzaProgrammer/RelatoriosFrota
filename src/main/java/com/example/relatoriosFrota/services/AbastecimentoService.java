package com.example.relatoriosFrota.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.relatoriosFrota.entities.FormularioCombustivel;
import com.example.relatoriosFrota.repository.AbastecimentoRepository;

@Service
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;

    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public FormularioCombustivel salvar(FormularioCombustivel abastecimento) {
        return abastecimentoRepository.save(abastecimento);
    }

    public List<FormularioCombustivel> listarTodos() {
        return abastecimentoRepository.findAll();
    }

    public FormularioCombustivel buscarPorId(Long id) {
        return abastecimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abastecimento não encontrado"));
    }

    public void deletar(Long id) {
        abastecimentoRepository.deleteById(id);
    }
}
