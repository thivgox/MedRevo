package med.revo.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.revo.api.controller.AtualizarDados;
import med.revo.api.domain.endereco.Endereco;

@Table(name="medicos")
@Entity(name= "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;


    public Medico(DadosCadastroMedicos dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
    }

    public void atualizarInfo(AtualizarDados atualizarDados) {
        if(atualizarDados.nome()!= null){
            this.nome = atualizarDados.nome();
        }
        if(atualizarDados.telefone()!= null){
            this.telefone = atualizarDados.telefone();
        }
        if(atualizarDados.email()!= null){
            this.email = atualizarDados.email();

        }
        if(atualizarDados.endereco() != null){
            this.endereco = atualizarDados.endereco();
        }


    }

    public void excluir(){
        this.ativo=false;
    }

}
