package com.example.relatoriosFrota.repository;

import com.example.relatoriosFrota.entities.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
}