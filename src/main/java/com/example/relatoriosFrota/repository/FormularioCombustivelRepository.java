package com.example.relatoriosFrota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.relatoriosFrota.entities.FormularioCombustivel;

public interface FormularioCombustivelRepository
    extends JpaRepository<FormularioCombustivel, Long> {
  List<FormularioCombustivel> findAllByOrderByDataDesc();

}