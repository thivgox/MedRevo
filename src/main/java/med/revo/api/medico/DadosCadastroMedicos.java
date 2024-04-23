package med.revo.api.medico;

import med.revo.api.endereco.DadosEndereco;

public record DadosCadastroMedicos(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco) {
}
