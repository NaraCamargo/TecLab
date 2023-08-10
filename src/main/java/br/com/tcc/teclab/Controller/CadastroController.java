package br.com.tcc.teclab.Controller;

import br.com.tcc.teclab.model.Cadastro;
import br.com.tcc.teclab.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/cadastro")
@RestController
public class CadastroController {

    @Autowired
    private CadastroRepository cadastroRepository;

    @GetMapping("/todos")
    public List<Cadastro> listarTodoscadastro() {
        return cadastroRepository.findAll();
    }
}
