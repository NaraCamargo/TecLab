package br.com.tcc.teclab.repository.Laboratorios;

import br.com.tcc.teclab.model.Laboratorios;
import br.com.tcc.teclab.repository.Filter.LaboratorioFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LaboratoriosRepositoryQuery {
    public Page<Laboratorios> Filtrar(LaboratorioFilter laboratorioFilter, Pageable pageable);
}
