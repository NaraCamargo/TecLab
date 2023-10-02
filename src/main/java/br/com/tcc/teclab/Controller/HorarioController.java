package br.com.tcc.teclab.Controller;

import br.com.tcc.teclab.model.Horarios;
import br.com.tcc.teclab.repository.Filter.HorariosFilter;
import br.com.tcc.teclab.repository.HorariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/horario")
@RestController
public class HorarioController {

    @Autowired
    private HorariosRepository horariosRepository;

    @GetMapping
    public Page<Horarios> pesquisar(HorariosFilter horariosFilter, Pageable pageable){
        return horariosRepository.Filtrar(horariosFilter, pageable);
    }

    @GetMapping("/todos")
    public List<Horarios> listarTodosHorarios(){
        return horariosRepository.findAll();
    }



}
