package br.com.tcc.teclab.repository;

import br.com.tcc.teclab.model.Cadastro;
import br.com.tcc.teclab.repository.Cadastro.CadastroRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer>, CadastroRepositoryQuery {
}
