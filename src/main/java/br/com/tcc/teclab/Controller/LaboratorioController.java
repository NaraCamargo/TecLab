package br.com.tcc.teclab.Controller;

import br.com.tcc.teclab.model.Laboratorios;
import br.com.tcc.teclab.repository.Filter.LaboratorioFilter;
import br.com.tcc.teclab.repository.LaboratoriosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/laboratorios")
@RestController
public class LaboratorioController {

    @Autowired
    private LaboratoriosRepository laboratoriosRepository;

    @GetMapping
    public Page<Laboratorios> pesquisar(LaboratorioFilter laboratorioFilter, Pageable pageable){
        return laboratoriosRepository.Filtrar(laboratorioFilter, pageable);
    }

    @GetMapping("/todos")
    public List<Laboratorios> listarTodosLaboratorios(){
        return laboratoriosRepository.findAll();
    }
}
