package br.com.tcc.teclab.Controller;

import br.com.tcc.teclab.model.Agendamento;
import br.com.tcc.teclab.model.Cadastro;
import br.com.tcc.teclab.model.Horarios;
import br.com.tcc.teclab.repository.AgendamentoRepository;
import br.com.tcc.teclab.repository.Filter.AgendamentoFilter;
import br.com.tcc.teclab.repository.Filter.CadastroFilter;
import br.com.tcc.teclab.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/agendamentos")
@RestController
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping()
    public Page<Agendamento> pesquisar(AgendamentoFilter agendamentoFilter, Pageable pageable){
        return agendamentoRepository.Filtrar(agendamentoFilter, pageable);
    }

    @GetMapping("/todos")
    public List<Agendamento> listarTodosAgendamentos() {
        return agendamentoRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String checkId(@PathVariable Integer idagendamento){
        if (agendamentoService.idExists(idagendamento)) {
            return "Horário já em uso " + idagendamento;
        } else {
            return "Horário reservado" + idagendamento;
        }

    }

}
