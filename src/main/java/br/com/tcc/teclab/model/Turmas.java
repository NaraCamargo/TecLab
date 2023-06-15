package br.com.tcc.teclab.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "turmas")
public class Turmas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idturma;
    private String turma;

    public Integer getIdturma() {
        return idturma;
    }

    public void setIdturma(Integer idturma) {
        this.idturma = idturma;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turmas turmas = (Turmas) o;
        return idturma.equals(turmas.idturma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idturma);
    }

    @OneToMany(mappedBy = "turmas")
    private List<Agendamento> agendamentoturmas = new ArrayList<>();

    public List<Agendamento> getAgendamentoturmas() {
        return agendamentoturmas;
    }

    public void setAgendamentoturmas(List<Agendamento> agendamentoturmas) {
        this.agendamentoturmas = agendamentoturmas;
    }
}
