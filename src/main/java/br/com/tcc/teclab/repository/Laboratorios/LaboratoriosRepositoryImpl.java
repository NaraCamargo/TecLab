package br.com.tcc.teclab.repository.Laboratorios;

import br.com.tcc.teclab.model.Laboratorios;
import br.com.tcc.teclab.repository.Filter.LaboratorioFilter;
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

public class LaboratoriosRepositoryImpl implements LaboratoriosRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Laboratorios> Filtrar(LaboratorioFilter laboratorioFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Laboratorios> criteria = builder.createQuery(Laboratorios.class);
        Root<Laboratorios> root = criteria.from(Laboratorios.class);

        Predicate[] predicates = criarRestricoes(laboratorioFilter, builder, root);
        criteria.where(predicates);

        criteria.orderBy(builder.asc(root.get("nomelab")));
        TypedQuery<Laboratorios> query = manager.createQuery(criteria);

        adicionarRestricoesDePagianacao(query, pageable);

        return new PageImpl<>(query.getResultList(),pageable, total(LaboratorioFilter));
    }

    private Long total(LaboratorioFilter laboratorioFilter) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Laboratorios> root = criteria.from(Laboratorios.class);

        Predicate[] predicates = criarRestricoes(laboratorioFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomeLab")));

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

    private Predicate[] criarRestricoes(LaboratorioFilter laboratorioFilter, CriteriaBuilder builder, Root<Laboratorios> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(!StringUtils.isEmpty(laboratorioFilter.getNomeLab())){
            predicates.add(builder.like(builder.lower(root.get("nomecLab")),
                    "%" + laboratorioFilter.getNomeLab().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }
}
