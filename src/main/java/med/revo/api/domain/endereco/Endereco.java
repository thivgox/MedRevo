package med.revo.api.domain.endereco;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.cep = endereco.cep();
     }

    public Endereco() {}

    public void  atualizarInfo(DadosEndereco dados) {
        if (dados.logradouro()!= null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.numero()!= null) {
            this.numero = dados.numero();
        }
        if (dados.bairro()!= null) {
            this.bairro = dados.bairro();
        }
        if (dados.cidade()!= null) {
            this.cidade = dados.cidade();
        }
        if (dados.uf()!= null) {
            this.uf = dados.uf();
        }
        if (dados.cep()!= null) {
            this.cep = dados.cep();
        }


     }


}
