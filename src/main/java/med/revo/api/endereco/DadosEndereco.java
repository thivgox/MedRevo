package med.revo.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotNull
        String logradouro,
        @NotNull
        String numero,
        @NotNull
        String bairro,
        @NotNull
        String cidade,
        @NotNull
        String uf,
        @NotNull
                @Pattern(regexp = "\\d{8}")
        String cep) {
}
