package br.com.tcc.teclab.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "horarios")
public class Horarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idhorario;
    private LocalTime horario;

    @JsonIgnore
    @OneToMany
    private List<Agendamento> agendamentohorario = new ArrayList<>();

    public List<Agendamento> getAgendamentohorario() {
        return agendamentohorario;
    }

    public void setAgendamentohorario(List<Agendamento> agendamentohorario) {
        this.agendamentohorario = agendamentohorario;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horarios horarios = (Horarios) o;
        return idhorario.equals(horarios.idhorario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idhorario);
    }
}
