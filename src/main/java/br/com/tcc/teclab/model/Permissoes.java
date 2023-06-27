package br.com.tcc.teclab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "permissoes")

public class Permissoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idpermissoes;
    private Integer idusuario;
    private String permissoes;

    @Override
    public int hashCode() {
        return Objects.hash(idpermissoes, idusuario);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Agendamento> agendamentousuario = new ArrayList<>();

    public List<Agendamento> getAgendamentousuario() {
        return agendamentousuario;
    }

    public void setAgendamentousuario(List<Agendamento> agendamentousuario) {
        this.agendamentousuario = agendamentousuario;
    }

    public Integer getIdpermissoes() {
        return idpermissoes;
    }

    public void setIdpermissoes(Integer idpermissoes) {
        this.idpermissoes = idpermissoes;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(String permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permissoes that = (Permissoes) o;
        return idpermissoes.equals(that.idpermissoes) && idusuario.equals(that.idusuario);
    }

}
