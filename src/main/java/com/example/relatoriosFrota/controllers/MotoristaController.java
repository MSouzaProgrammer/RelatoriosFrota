package com.example.relatoriosFrota.controllers;

import com.example.relatoriosFrota.entities.Motorista;
import com.example.relatoriosFrota.services.MotoristaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
@RequiredArgsConstructor
public class MotoristaController {

    private final MotoristaService motoristaService;

    @GetMapping
    public ResponseEntity<List<Motorista>> listar() {
        return ResponseEntity.ok(motoristaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorista> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(motoristaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Motorista> cadastrar(
            @RequestBody Motorista motorista
    ) {
        return ResponseEntity.ok(
                motoristaService.cadastrar(motorista)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motorista> atualizar(
            @PathVariable Long id,
            @RequestBody Motorista motorista
    ) {
        return ResponseEntity.ok(
                motoristaService.atualizar(id, motorista)
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Motorista> alterarStatus(
            @PathVariable Long id,
            @RequestBody Boolean ativo
    ) {
        return ResponseEntity.ok(
                motoristaService.alterarStatus(id, ativo)
        );
    }
}