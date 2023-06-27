package br.com.tcc.teclab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idusuario;
    private String nomeusuario;
    private String email;
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Agendamento> agendamentousuario = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "permissoes")
    private Permissoes permissoes;

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public List<Agendamento> getAgendamentousuario() {
        return agendamentousuario;
    }

    public void setAgendamentousuario(List<Agendamento> agendamentousuario) {
        this.agendamentousuario = agendamentousuario;
    }

    public Permissoes getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Permissoes permissoes) {
        this.permissoes = permissoes;
    }

    public Integer getIdusuario() { return idusuario; }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idusuario.equals(usuario.idusuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idusuario);
    }
}
