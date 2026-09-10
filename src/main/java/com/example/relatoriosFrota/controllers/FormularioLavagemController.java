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

import com.example.relatoriosFrota.dto.request.FormularioLavagemRequest;
import com.example.relatoriosFrota.entities.FormularioLavagem;
import com.example.relatoriosFrota.services.FormularioLavagemService;

@RestController
@RequestMapping("/lavagens")
public class FormularioLavagemController {

    private final FormularioLavagemService formularioLavagemService;

    public FormularioLavagemController(
            FormularioLavagemService formularioLavagemService
    ) {
        this.formularioLavagemService = formularioLavagemService;
    }

    @PostMapping
    public ResponseEntity<FormularioLavagem> salvar(
            @RequestBody FormularioLavagemRequest request
    ) {
        return ResponseEntity.ok(
                formularioLavagemService.salvar(request)
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
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                formularioLavagemService.buscarPorId(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id
    ) {
        formularioLavagemService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}