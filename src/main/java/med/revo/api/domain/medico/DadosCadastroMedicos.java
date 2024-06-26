package med.revo.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.revo.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedicos(
       @NotNull
        String nome,
        @NotNull
        @Email
        String email,
        @NotNull
        String telefone,
        @NotNull
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
