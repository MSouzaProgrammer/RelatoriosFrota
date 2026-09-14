package com.example.relatoriosFrota.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.relatoriosFrota.entities.Veiculo;
import com.example.relatoriosFrota.services.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(
            VeiculoService veiculoService
    ) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Veiculo> salvar(
            @RequestBody Veiculo veiculo
    ) {
        return ResponseEntity.ok(
                veiculoService.salvar(veiculo)
        );
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos() {
        return ResponseEntity.ok(
                veiculoService.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                veiculoService.buscarPorId(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(
            @PathVariable Long id,
            @RequestBody Veiculo veiculo
    ) {
        Veiculo existente =
                veiculoService.buscarPorId(id);

        existente.setPlaca(
                veiculo.getPlaca()
        );

        existente.setModelosVeiculos(
                veiculo.getModelosVeiculos()
        );

        existente.setMarca(
                veiculo.getMarca()
        );

        existente.setAno(
                veiculo.getAno()
        );

        existente.setKm(
                veiculo.getKm()
        );

        existente.setFilial(
                veiculo.getFilial()
        );

        existente.setStatus(
                veiculo.getStatus()
        );

        return ResponseEntity.ok(
                veiculoService.salvar(
                        existente
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id
    ) {
        veiculoService.deletar(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}