package br.com.tcc.teclab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.security.PrivateKey;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="agendamento")

public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idagendamento;
    private LocalDate data;

    public Integer getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(Integer idagendamento) {
        this.idagendamento = idagendamento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JoinColumn(name = "horarios")
    private Horarios horarios;


    @ManyToOne
    @JoinColumn(name="idlaboratorios")
    private Laboratorios laboratorios;


    @ManyToOne
    @JoinColumn(name = "idturma")
    private Turmas turmas;

    public Horarios getHorarios() {
        return horarios;
    }

    public void setHorarios(Horarios horarios) {
        this.horarios = horarios;
    }

    public Laboratorios getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(Laboratorios laboratorios) {
        this.laboratorios = laboratorios;
    }

    public Turmas getTurmas() {
        return turmas;
    }

    public void setTurmas(Turmas turmas) {
        this.turmas = turmas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return idagendamento.equals(that.idagendamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idagendamento);
    }
}