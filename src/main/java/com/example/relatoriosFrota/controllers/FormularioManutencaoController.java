package com.example.relatoriosFrota.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.relatoriosFrota.entities.FormularioManutencao;
import com.example.relatoriosFrota.services.ManutencaoService;

import java.util.List;

@RestController
@RequestMapping("/manutencoes")
public class FormularioManutencaoController {

    private final ManutencaoService formularioManutencaoService;

    public FormularioManutencaoController(
            ManutencaoService formularioManutencaoService) {
        this.formularioManutencaoService = formularioManutencaoService;
    }

    @PostMapping
    public ResponseEntity<FormularioManutencao> salvar(
            @RequestBody FormularioManutencao formulario) {

        return ResponseEntity.ok(
                formularioManutencaoService.salvar(formulario)
        );
    }

    @GetMapping
    public ResponseEntity<List<FormularioManutencao>> listarTodos() {

        return ResponseEntity.ok(
                formularioManutencaoService.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormularioManutencao> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                formularioManutencaoService.buscarPorId(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        formularioManutencaoService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}