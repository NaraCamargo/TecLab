package br.com.tcc.teclab.repository;

import br.com.tcc.teclab.model.Turmas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmasRepository extends JpaRepository<Turmas, Integer> {



}
