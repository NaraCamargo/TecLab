package br.com.tcc.teclab.Controller;

import br.com.tcc.teclab.model.Laboratorios;
import br.com.tcc.teclab.repository.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/laboratorios")
@RestController
public class LaboratorioController {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @GetMapping("/todos")
    public List<Laboratorios> listarTodosLaboratorios(){
        return laboratorioRepository.findAll();
    }


}
