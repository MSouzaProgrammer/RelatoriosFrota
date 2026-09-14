package com.example.relatoriosFrota.services;

import com.example.relatoriosFrota.entities.Motorista;
import com.example.relatoriosFrota.repository.MotoristaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;

    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public List<Motorista> listarTodos() {
        return motoristaRepository.findAll();
    }

    public Motorista buscarPorId(Long id) {
        return motoristaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
    }

    public Motorista cadastrar(Motorista motorista) {
        motorista.setId(null);
        motorista.setAtivo(true);

        return motoristaRepository.save(motorista);
    }

    public Motorista atualizar(Long id, Motorista dados) {

        Motorista motorista = buscarPorId(id);

        motorista.setNome(dados.getNome());
        motorista.setCpf(dados.getCpf());
        motorista.setCnh(dados.getCnh());

        return motoristaRepository.save(motorista);
    }

    public Motorista alterarStatus(Long id, Boolean ativo) {

        Motorista motorista = buscarPorId(id);

        motorista.setAtivo(ativo);

        return motoristaRepository.save(motorista);
    }
}