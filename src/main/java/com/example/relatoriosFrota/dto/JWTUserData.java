package com.example.relatoriosFrota.dto;
import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
