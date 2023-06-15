package br.com.tcc.teclab.model;

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

    @OneToMany(mappedBy = "horario")
    private List<Agendamento> agendamentohorario = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "laboratorios")
    private List<Agendamento> agendamentolaboratorios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "turma")
    private Turmas turmas;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Agendamento> getAgendamentohorario() {
        return agendamentohorario;
    }

    public void setAgendamentohorario(List<Agendamento> agendamentohorario) {
        this.agendamentohorario = agendamentohorario;
    }

    public List<Agendamento> getAgendamentolaboratorios() {
        return agendamentolaboratorios;
    }

    public void setAgendamentolaboratorios(List<Agendamento> agendamentolaboratorios) {
        this.agendamentolaboratorios = agendamentolaboratorios;
    }

    public Turmas getTurmas() {
        return turmas;
    }

    public void setTurmas(Turmas turmas) {
        this.turmas = turmas;
    }
}