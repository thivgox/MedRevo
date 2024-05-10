package med.revo.api.domain.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.revo.api.domain.medico.*;
import med.revo.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity  cadastrar(@RequestBody @Valid DadosCadastroMedicos dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);

        repository.save(medico);

         var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

         return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));

    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemMedicos>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page =  repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarDados atualizarDados ){
        var medico = repository.getReferenceById(atualizarDados.id());
        medico.atualizarInfo(atualizarDados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return  ResponseEntity.noContent().build();
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);


        return  ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

}
