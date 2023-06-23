package br.com.tcc.teclab.model;


import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "horarios")
public class Horarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idhorario;
    private Time horario;

    @ManyToOne
    @JoinColumn(name = "idagendamento")
    private Agendamento agendamento;


    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
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
