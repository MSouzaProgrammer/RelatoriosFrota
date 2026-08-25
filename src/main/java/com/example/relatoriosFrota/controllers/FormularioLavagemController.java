package com.example.relatoriosFrota.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.relatoriosFrota.entities.FormularioLavagem;
import com.example.relatoriosFrota.services.LavagemService;

import java.util.List;

@RestController
@RequestMapping("/lavagens")
public class FormularioLavagemController {

    private final LavagemService formularioLavagemService;

    public FormularioLavagemController(
            LavagemService formularioLavagemService) {
        this.formularioLavagemService = formularioLavagemService;
    }

    @PostMapping
    public ResponseEntity<FormularioLavagem> salvar(
            @RequestBody FormularioLavagem formulario) {

        return ResponseEntity.ok(
                formularioLavagemService.salvar(formulario)
        );
    }

    @GetMapping
    public ResponseEntity<List<FormularioLavagem>> listarTodos() {

        return ResponseEntity.ok(
                formularioLavagemService.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormularioLavagem> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                formularioLavagemService.buscarPorId(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        formularioLavagemService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}