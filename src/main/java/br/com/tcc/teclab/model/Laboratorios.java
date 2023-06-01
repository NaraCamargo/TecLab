package br.com.tcc.teclab.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "laboratorios")
public class Laboratorios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idlaboratorios;
    private String nomelab;

    public Integer getIdlaboratorios() {
        return idlaboratorios;
    }

    public void setIdlaboratorios(Integer idlaboratorios) {
        this.idlaboratorios = idlaboratorios;
    }

    public String getNomelab() {
        return nomelab;
    }

    public void setNomelab(String nomelab) {
        this.nomelab = nomelab;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laboratorios that = (Laboratorios) o;
        return idlaboratorios.equals(that.idlaboratorios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idlaboratorios);
    }

}
