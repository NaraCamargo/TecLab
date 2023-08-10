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
    private String permissoes;

    @JsonIgnore
    @OneToMany(mappedBy = "cadastro")
    private List<Agendamento> agendamentousuario = new ArrayList<>();

    public Integer getIdpermissoes() {
        return idpermissoes;
    }

    public void setIdpermissoes(Integer idpermissoes) {
        this.idpermissoes = idpermissoes;
    }

    public String getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(String permissoes) {
        this.permissoes = permissoes;
    }

    public List<Agendamento> getAgendamentousuario() {
        return agendamentousuario;
    }

    public void setAgendamentousuario(List<Agendamento> agendamentousuario) {
        this.agendamentousuario = agendamentousuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permissoes that = (Permissoes) o;
        return idpermissoes.equals(that.idpermissoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpermissoes);
    }
}
