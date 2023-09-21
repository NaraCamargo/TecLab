package br.com.tcc.teclab.Controller;

import br.com.tcc.teclab.model.Agendamento;
import br.com.tcc.teclab.repository.AgendamentoRepository;
import br.com.tcc.teclab.repository.Filter.CadastroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/agendamentos")
@RestController
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @GetMapping("/todos")
    public List<Agendamento> listarTodosAgendamentos() {
        return agendamentoRepository.findAll();
    }

}
