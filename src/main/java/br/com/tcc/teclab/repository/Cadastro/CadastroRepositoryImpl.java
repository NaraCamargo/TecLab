package br.com.tcc.teclab.repository.Cadastro;

import br.com.tcc.teclab.model.Cadastro;
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
import java.util.ArrayList;
import java.util.List;

public class CadastroRepositoryImpl implements CadastroRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Cadastro> Filtrar(CadastroFilter cadastroFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Cadastro> criteria = builder.createQuery(Cadastro.class);
        Root<Cadastro> root = criteria.from(Cadastro.class);

        Predicate[] predicates = criarRestricoes(cadastroFilter, builder, root);
        criteria.where(predicates);

        criteria.orderBy(builder.asc(root.get("nomeusuario")));
        TypedQuery<Cadastro> query = manager.createQuery(criteria);

        adicionarRestricoesDePagianacao(query, pageable);

        return new PageImpl<>(query.getResultList(),pageable, total(cadastroFilter));
    }

    private Long total(CadastroFilter cadastroFilter) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Cadastro> root = criteria.from(Cadastro.class);

        Predicate[] predicates = criarRestricoes(cadastroFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomeusuario")));

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

    private Predicate[] criarRestricoes(CadastroFilter cadastroFilter, CriteriaBuilder builder, Root<Cadastro> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(!StringUtils.isEmpty(cadastroFilter.getNomeusuario())){
            predicates.add(builder.like(builder.lower(root.get("nomecliente")),
                    "%" + cadastroFilter.getNomeusuario().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }
}
