package com.example.relatoriosFrota.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.relatoriosFrota.entities.FormularioLavagem;
import com.example.relatoriosFrota.repository.LavagemRepository;

@Service
public class LavagemService {
private final LavagemRepository lavagemRepository;

    public LavagemService(LavagemRepository lavagemRepository) {
        this.lavagemRepository = lavagemRepository;
    }

    public FormularioLavagem salvar(FormularioLavagem lavagem) {
        return lavagemRepository.save(lavagem);
    }

    public List<FormularioLavagem> listarTodos() {
        return lavagemRepository.findAll();
    }

    public FormularioLavagem buscarPorId(Long id) {
        return lavagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lavagem não encontrada"));
    }

    public void deletar(Long id) {
        lavagemRepository.deleteById(id);
    }
}
