package br.com.tcc.teclab.Controller;

import br.com.tcc.teclab.model.Permissoes;
import br.com.tcc.teclab.repository.Filter.PermissoesFilter;
import br.com.tcc.teclab.repository.PermissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/permissoes")
@RestController
public class PermissoesController {

    @Autowired
    private PermissoesRepository permissoesRepository;

    @GetMapping
    public Page<Permissoes> pesquisar(PermissoesFilter permissoesFilter, Pageable pageable){
        return permissoesRepository.Filtrar(permissoesFilter, pageable);
    }

    @GetMapping("/todos")
    public List<Permissoes> listarTodosPermissoes(){
        return permissoesRepository.findAll();
    }

}
