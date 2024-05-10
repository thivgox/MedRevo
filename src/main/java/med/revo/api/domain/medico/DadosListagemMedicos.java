package med.revo.api.medico;

public record DadosListagemMedicos(String nome,Long id,String email, String crm, Especialidade especialidade) {

    public DadosListagemMedicos(Medico medico){
        this(medico.getNome(), medico.getId(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
     }


}
