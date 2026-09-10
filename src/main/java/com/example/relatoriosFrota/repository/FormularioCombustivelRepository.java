package com.example.relatoriosFrota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.relatoriosFrota.entities.FormularioCombustivel;

public interface FormularioCombustivelRepository
        extends JpaRepository<FormularioCombustivel, Long> {

}