package br.com.tcc.teclab.repository;

import br.com.tcc.teclab.model.Agendamento;
import br.com.tcc.teclab.repository.Agendamento.AgendamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>, AgendamentoRepositoryQuery {


}
