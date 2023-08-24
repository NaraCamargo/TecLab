package br.com.tcc.teclab.repository.Dtos;

import java.time.LocalTime;

public class AgendamentoDtos {

    private Integer idagendamento;
    private String nomeusuario;
    private LocalTime horario;
    private String nomeLab;

    public AgendamentoDtos(Integer idagendamento, String nomeusuario, LocalTime horario, String nomeLab) {
        this.idagendamento = idagendamento;
        this.nomeusuario = nomeusuario;
        this.horario = horario;
        this.nomeLab = nomeLab;
    }

    public Integer getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(Integer idagendamento) {
        this.idagendamento = idagendamento;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getNomeLab() {
        return nomeLab;
    }

    public void setNomeLab(String nomeLab) {
        this.nomeLab = nomeLab;
    }
}
