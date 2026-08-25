package com.example.relatoriosFrota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.relatoriosFrota.entities.FormularioLavagem;

public interface LavagemRepository extends JpaRepository<FormularioLavagem, Long> {
}