package br.com.tcc.teclab.repository;

import br.com.tcc.teclab.model.Permissoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissoesRepository extends JpaRepository<Permissoes, Integer> {
}
