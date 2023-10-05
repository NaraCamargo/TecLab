package br.com.tcc.teclab.repository.Agendamento;

import br.com.tcc.teclab.model.Agendamento;

import br.com.tcc.teclab.model.Cadastro;
import br.com.tcc.teclab.repository.Filter.AgendamentoFilter;
import br.com.tcc.teclab.repository.Filter.CadastroFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgendamentoRepositoryImpl implements AgendamentoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Agendamento> Filtrar(AgendamentoFilter agendamentoFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Agendamento> criteria = builder.createQuery(Agendamento.class);
        Root<Agendamento> root = criteria.from(Agendamento.class);

        Predicate[] predicates = criarRestricoes(agendamentoFilter, builder, root);
        criteria.where(predicates);

        criteria.orderBy(builder.asc(root.get("data")));
        TypedQuery<Agendamento> query = manager.createQuery(criteria);

        adicionarRestricoesDePagianacao(query, pageable);

        return new PageImpl<>(query.getResultList(),pageable, total(agendamentoFilter));
    }

    private Long total(AgendamentoFilter agendamentoFilter) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Agendamento> root = criteria.from(Agendamento.class);

        Predicate[] predicates = criarRestricoes(agendamentoFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("data")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesDePagianacao(TypedQuery<?> query, Pageable pageable) {

        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroPágina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroPágina);
        query.setMaxResults(totalRegistrosPorPagina);

    }

    private Predicate[] criarRestricoes(AgendamentoFilter agendamentoFilter, CriteriaBuilder builder, Root<Agendamento> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(!StringUtils.isEmpty(agendamentoFilter.getData())){
            predicates.add(builder.like(builder.lower(root.get("data")),
                    "%" + agendamentoFilter.getData().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }
}
