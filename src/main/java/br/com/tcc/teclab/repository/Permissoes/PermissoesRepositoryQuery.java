package br.com.tcc.teclab.repository.Permissoes;

import br.com.tcc.teclab.model.Permissoes;
import br.com.tcc.teclab.repository.Filter.PermissoesFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermissoesRepositoryQuery {

    public Page<Permissoes> Filtrar(PermissoesFilter permissoesFilter, Pageable pageable);
}
