package com.example.relatoriosFrota.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record AlterarSenhaRequest(@NotEmpty(message = "Email obrigatório!") String email,
        @NotEmpty(message = "Nova senha obrigatória!") String novaSenha) {

}
