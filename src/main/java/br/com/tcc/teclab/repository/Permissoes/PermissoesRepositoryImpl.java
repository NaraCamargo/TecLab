package br.com.tcc.teclab.repository.Permissoes;
import br.com.tcc.teclab.model.Permissoes;
import br.com.tcc.teclab.repository.Filter.PermissoesFilter;
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

public class PermissoesRepositoryImpl implements PermissoesRepositoryQuery {

        @PersistenceContext
        private EntityManager manager;

        @Override
        public Page<Permissoes> Filtrar(PermissoesFilter permissoesFilter, Pageable pageable) {

            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Permissoes> criteria = builder.createQuery(Permissoes.class);
            Root<Permissoes> root = criteria.from(Permissoes.class);

            Predicate[] predicates = criarRestricoes(permissoesFilter, builder, root);
            criteria.where(predicates);

            criteria.orderBy(builder.asc(root.get("permissoes")));
            TypedQuery<Permissoes> query = manager.createQuery(criteria);

            adicionarRestricoesDePagianacao(query, pageable);

            return new PageImpl<>(query.getResultList(),pageable, total(permissoesFilter));
        }

        private Long total(PermissoesFilter permissoesFilter) {

            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
            Root<Permissoes> root = criteria.from(Permissoes.class);

            Predicate[] predicates = criarRestricoes(permissoesFilter, builder, root);
            criteria.where(predicates);
            criteria.orderBy(builder.asc(root.get("permissoes")));

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

        private Predicate[] criarRestricoes(PermissoesFilter permissoesFilter, CriteriaBuilder builder, Root<Permissoes> root) {

            List<Predicate> predicates = new ArrayList<>();

            if(!StringUtils.isEmpty(permissoesFilter.getPermissoes())){
                predicates.add(builder.like(builder.lower(root.get("permissoes")),
                        "%" + permissoesFilter.getPermissoes().toLowerCase() + "%"));
            }

            return predicates.toArray(new Predicate[predicates.size()]);

        }

}
