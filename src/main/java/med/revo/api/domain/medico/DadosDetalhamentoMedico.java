package med.revo.api.medico;

import med.revo.api.endereco.DadosEndereco;
import med.revo.api.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Endereco endereco) {
public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(),medico.getEndereco());
    }
}
