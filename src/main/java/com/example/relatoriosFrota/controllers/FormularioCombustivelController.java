package com.example.relatoriosFrota.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.relatoriosFrota.entities.FormularioCombustivel;
import com.example.relatoriosFrota.services.AbastecimentoService;

import java.util.List;

@RestController
@RequestMapping("/combustiveis")
public class FormularioCombustivelController {

    private final AbastecimentoService abastecimentoService;

    public FormularioCombustivelController(
            AbastecimentoService formularioCombustivelService) {
        this.abastecimentoService = formularioCombustivelService;
    }

    @PostMapping
    public ResponseEntity<FormularioCombustivel> salvar(
            @RequestBody FormularioCombustivel formulario) {

        return ResponseEntity.ok(
                abastecimentoService.salvar(formulario)
        );
    }

    @GetMapping
    public ResponseEntity<List<FormularioCombustivel>> listarTodos() {

        return ResponseEntity.ok(
                abastecimentoService.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormularioCombustivel> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                abastecimentoService.buscarPorId(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        abastecimentoService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
