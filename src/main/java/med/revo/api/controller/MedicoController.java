package med.revo.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.revo.api.medico.DadosCadastroMedicos;
import med.revo.api.medico.DadosListagemMedicos;
import med.revo.api.medico.Medico;
import med.revo.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dados ){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarDados atualizarDados ){
        var medico = repository.getReferenceById(atualizarDados.id());
        medico.atualizarInfo(atualizarDados);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);

    }

}
