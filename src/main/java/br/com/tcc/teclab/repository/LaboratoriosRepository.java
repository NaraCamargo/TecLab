package br.com.tcc.teclab.repository;

import br.com.tcc.teclab.model.Laboratorios;
import br.com.tcc.teclab.repository.Laboratorios.LaboratoriosRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoriosRepository extends JpaRepository<Laboratorios, Integer>, LaboratoriosRepositoryQuery {
}
