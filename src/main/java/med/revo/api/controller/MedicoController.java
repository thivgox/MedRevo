package med.revo.api.controller;

import jakarta.transaction.Transactional;
import med.revo.api.medico.DadosCadastroMedicos;
import med.revo.api.medico.Medico;
import med.revo.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedicos dados ){
        repository.save(new Medico(dados));
    }

}
