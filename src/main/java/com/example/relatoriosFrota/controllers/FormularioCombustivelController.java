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

import com.example.relatoriosFrota.dto.request.FormularioCombustivelRequest;
import com.example.relatoriosFrota.entities.FormularioCombustivel;
import com.example.relatoriosFrota.services.FormularioCombustivelService;

@RestController
@RequestMapping("/combustiveis")
public class FormularioCombustivelController {

    private final FormularioCombustivelService formularioCombustivelService;

    public FormularioCombustivelController(
            FormularioCombustivelService formularioCombustivelService
    ) {
        this.formularioCombustivelService = formularioCombustivelService;
    }

    @PostMapping
    public ResponseEntity<FormularioCombustivel> salvar(
            @RequestBody FormularioCombustivelRequest request
    ) {
        return ResponseEntity.ok(
                formularioCombustivelService.salvar(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<FormularioCombustivel>> listarTodos() {
        return ResponseEntity.ok(
                formularioCombustivelService.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormularioCombustivel> buscarPorId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                formularioCombustivelService.buscarPorId(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id
    ) {
        formularioCombustivelService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}