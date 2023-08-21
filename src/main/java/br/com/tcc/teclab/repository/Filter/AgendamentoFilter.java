package br.com.tcc.teclab.repository.Filter;

import java.time.LocalTime;

public class AgendamentoFilter {

    private String nomeusuario;
    private LocalTime horario;
    private String nomelab;

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

    public String getNomelab() {
        return nomelab;
    }

    public void setNomelab(String nomelab) {
        this.nomelab = nomelab;
    }
}
