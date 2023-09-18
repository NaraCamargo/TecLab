package br.com.tcc.teclab.repository.Horarios;

import br.com.tcc.teclab.model.Horarios;
import br.com.tcc.teclab.repository.Filter.HorariosFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HorariosRepositoryQuery {

    public Page<Horarios> Filtrar(HorariosFilter horariosFilter, Pageable pageable);

}
