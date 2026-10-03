package com.example.relatoriosFrota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.relatoriosFrota.entities.FormularioManutencao;

public interface ManutencaoRepository extends JpaRepository<FormularioManutencao, Long> {
  List<FormularioManutencao> findAllByOrderByDataDesc();
}