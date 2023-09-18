package br.com.tcc.teclab.Controller;

import br.com.tcc.teclab.model.Cadastro;
import br.com.tcc.teclab.repository.CadastroRepository;
import br.com.tcc.teclab.repository.Filter.CadastroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/cadastro")
@RestController
public class CadastroController {

    @Autowired
        private CadastroRepository cadastroRepository;

    @GetMapping()
    public Page<Cadastro> pesquisar(CadastroFilter cadastroFilter, Pageable pageable){
        return cadastroRepository.Filtrar(cadastroFilter, pageable);
    }

    @GetMapping("/todos")
        public List<Cadastro> listarTodoscadastro() {
            return cadastroRepository.findAll();
    }
}
