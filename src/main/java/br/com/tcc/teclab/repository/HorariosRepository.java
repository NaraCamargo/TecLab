package br.com.tcc.teclab.repository;

import br.com.tcc.teclab.model.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariosRepository extends JpaRepository <Horarios, Integer> {
}
