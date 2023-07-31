package br.com.tcc.teclab.Controller;

import br.com.tcc.teclab.model.Turmas;
import br.com.tcc.teclab.repository.TurmasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/turmas")
public class TurmasController {

    @Autowired
    private TurmasRepository turmasRepository;

    @GetMapping("/todos")
    public List<Turmas> listartodasturmas(){
        return turmasRepository.findAll();
    }
}

