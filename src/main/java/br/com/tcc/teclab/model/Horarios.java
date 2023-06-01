package br.com.tcc.teclab.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "horarios")
public class Horarios {

    private Integer idhorario;
    private LocalTime horario;

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
