package med.revo.api.domain.controller;

import jakarta.validation.constraints.NotNull;
import med.revo.api.domain.endereco.Endereco;

public record AtualizarDados(
        @NotNull
        Long id,
        Endereco endereco,
        String nome,
        String telefone,
        String email ) {
}
