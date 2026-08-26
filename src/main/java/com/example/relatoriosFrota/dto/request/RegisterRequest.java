package com.example.relatoriosFrota.dto.request;

import jakarta.validation.constraints.NotEmpty;
import com.example.relatoriosFrota.enuns.Access;

public record RegisterRequest(@NotEmpty(message = "Nome obrigatório!") String name,
                              @NotEmpty(message = "Email obrigatório!") String email,
                              @NotEmpty(message = "Senha obrigatório!") String password,
                                                                        Access access){
}
