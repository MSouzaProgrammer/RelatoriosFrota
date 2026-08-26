package com.example.relatoriosFrota.dto.response;

import com.example.relatoriosFrota.enuns.Access;

public record RegisterUserResponse(String name, String email, Access access) {
}
