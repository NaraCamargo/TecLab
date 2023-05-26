package br.com.tcc.teclab.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name="agendamento")

public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idagendamento;
    private Integer idusuario;
    private Integer idlaboratorio;
    private Integer idturma;
    private LocalTime idhorario;
    private LocalDate data;

    public Integer getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(Integer idagendamento) {
        this.idagendamento = idagendamento;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdlaboratorio() {
        return idlaboratorio;
    }

    public void setIdlaboratorio(Integer idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public Integer getIdturma() {
        return idturma;
    }

    public void setIdturma(Integer idturma) {
        this.idturma = idturma;
    }

    public LocalTime getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(LocalTime idhorario) {
        this.idhorario = idhorario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return idagendamento.equals(that.idagendamento) && idusuario.equals(that.idusuario) && idlaboratorio.equals(that.idlaboratorio) && idturma.equals(that.idturma) && idhorario.equals(that.idhorario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idagendamento, idusuario, idlaboratorio, idturma, idhorario);
    }
}
