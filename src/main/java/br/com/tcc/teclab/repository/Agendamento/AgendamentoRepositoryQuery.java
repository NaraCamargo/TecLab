package br.com.tcc.teclab.repository.Agendamento;

import br.com.tcc.teclab.repository.Dtos.AgendamentoDtos;
import br.com.tcc.teclab.repository.Filter.AgendamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AgendamentoRepositoryQuery {

    public Page<AgendamentoDtos> Filtrar(AgendamentoFilter agendamentoFilter, Pageable pageable);
}
