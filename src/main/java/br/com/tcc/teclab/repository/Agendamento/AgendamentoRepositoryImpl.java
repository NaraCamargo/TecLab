package br.com.tcc.teclab.repository.Agendamento;

import br.com.tcc.teclab.model.Agendamento;
import br.com.tcc.teclab.repository.Filter.AgendamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public class AgendamentoRepositoryImpl implements AgendamentoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Agendamento> Filtrar(AgendamentoFilter agendamentoFilter, Pageable pageable) {

        CriteriaQuery<Agendamento> criteria = builder.createQuery(Agendamento.class);

        return null;
    }
}
