package br.com.tcc.teclab.repository.Filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AgendamentoFilter {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
