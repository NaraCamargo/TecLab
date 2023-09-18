package br.com.tcc.teclab.repository.Cadastro;

import br.com.tcc.teclab.model.Cadastro;
import br.com.tcc.teclab.repository.Filter.CadastroFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CadastroRepositoryQuery {

    public Page<Cadastro> Filtrar(CadastroFilter cadastroFilter, Pageable pageable);

}
