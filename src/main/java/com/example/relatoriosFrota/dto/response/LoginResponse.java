package com.example.relatoriosFrota.dto.response;

import com.example.relatoriosFrota.enuns.Access;

public record LoginResponse(String token, String name, Access access) {
}
