package com.example.relatoriosFrota.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.relatoriosFrota.entities.Veiculo;
import com.example.relatoriosFrota.repository.VeiculoRepository;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(
            VeiculoRepository veiculoRepository
    ) {
        this.veiculoRepository =
                veiculoRepository;
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Veículo não encontrado"
                        )
                );
    }

    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }
}