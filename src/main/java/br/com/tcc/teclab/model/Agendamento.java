package br.com.tcc.teclab.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Agendamento")

public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idagendamento;

    private Date data;


    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Cadastro cadastro;

    @ManyToOne
    @JoinColumn(name = "idhorario")
    private Horarios horarios;

    @ManyToOne
    @JoinColumn(name="idlaboratorio")
    private Laboratorios laboratorios;

    public Integer getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(Integer idagendamento) {
        this.idagendamento = idagendamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

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