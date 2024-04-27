package med.revo.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.revo.api.medico.DadosCadastroMedicos;
import med.revo.api.medico.DadosListagemMedicos;
import med.revo.api.medico.Medico;
import med.revo.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public List<DadosListagemMedicos> listar() {
        return repository.findAll().stream().map(DadosListagemMedicos::new).toList();
    }
}
