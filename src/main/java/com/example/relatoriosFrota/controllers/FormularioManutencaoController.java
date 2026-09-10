package com.example.relatoriosFrota.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.relatoriosFrota.dto.request.FormularioManutencaoRequest;
import com.example.relatoriosFrota.entities.FormularioManutencao;
import com.example.relatoriosFrota.services.FormularioManutencaoService;

@RestController
@RequestMapping("/manutencoes")
public class FormularioManutencaoController {

    private final FormularioManutencaoService formularioManutencaoService;

    public FormularioManutencaoController(
            FormularioManutencaoService formularioManutencaoService
    ) {
        this.formularioManutencaoService = formularioManutencaoService;
    }

    @PostMapping
    public ResponseEntity<FormularioManutencao> salvar(
            @RequestBody FormularioManutencaoRequest request
    ) {
        return ResponseEntity.ok(
                formularioManutencaoService.salvar(request)
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
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                formularioManutencaoService.buscarPorId(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id
    ) {
        formularioManutencaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}