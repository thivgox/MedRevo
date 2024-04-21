package med.revo.api;

public record DadosCadastroMedicos(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco) {
}
