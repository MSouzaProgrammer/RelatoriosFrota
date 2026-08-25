package com.example.relatoriosFrota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.relatoriosFrota.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}