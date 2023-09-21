package br.com.tcc.teclab.repository.Horarios;

import br.com.tcc.teclab.model.Horarios;
import br.com.tcc.teclab.repository.Filter.HorariosFilter;
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
import java.util.ArrayList;
import java.util.List;

public class HorariosRepositoryImpl implements HorariosRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Horarios> Filtrar(HorariosFilter horariosFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Horarios> criteria = builder.createQuery(Horarios.class);
        Root<Horarios> root = criteria.from(Horarios.class);

        Predicate[] predicates = criarRestricoes(horariosFilter, builder, root);
        criteria.where(predicates);

        criteria.orderBy(builder.asc(root.get("horario")));
        TypedQuery<Horarios> query = manager.createQuery(criteria);

        adicionarRestricoesDePagianacao(query, pageable);

        return new PageImpl<>(query.getResultList(),pageable, total(horariosFilter));
    }

    private Long total(HorariosFilter horariosFilter) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Horarios> root = criteria.from(Horarios.class);

        Predicate[] predicates = criarRestricoes(horariosFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("horario")));

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

    private Predicate[] criarRestricoes(HorariosFilter horariosFilter, CriteriaBuilder builder, Root<Horarios> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(!StringUtils.isEmpty(horariosFilter.getHorario())){
            predicates.add(builder.like(builder.lower(root.get("horario")),
                    "%" + horariosFilter.getHorario().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }
}
