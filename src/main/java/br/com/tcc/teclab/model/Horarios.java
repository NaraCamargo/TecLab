package br.com.tcc.teclab.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Horarios")
public class Horarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idhorario;
    private String horario;

    //chave estrangeira para o laboratorio

    @JsonIgnore
    @OneToMany(mappedBy = "horarios")
    private List<Agendamento> agendamento = new ArrayList<>();

    public List<Agendamento> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<Agendamento> agendamento) {
        this.agendamento = agendamento;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
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
