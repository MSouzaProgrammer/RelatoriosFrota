package com.example.relatoriosFrota.controllers;


import com.example.relatoriosFrota.dto.request.FormularioCombustivelRequest;
import com.example.relatoriosFrota.entities.FormularioCombustivel;
import com.example.relatoriosFrota.services.FormularioCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combustiveis")
@RequiredArgsConstructor
public class FormularioCombustivelController {

    private final FormularioCombustivelService formularioCombustivelService;

    @PostMapping
    public ResponseEntity<FormularioCombustivel> salvar(
            @RequestBody FormularioCombustivelRequest request
    ) {

        return ResponseEntity.ok(
                formularioCombustivelService.salvar(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormularioCombustivel> atualizar(
            @PathVariable Long id,
            @RequestBody FormularioCombustivelRequest request
    ) {

        return ResponseEntity.ok(
                formularioCombustivelService.atualizar(id, request)
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