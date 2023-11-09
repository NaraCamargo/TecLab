package br.com.tcc.teclab.service;

import br.com.tcc.teclab.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public boolean idExists(Integer idagendamento) {
        return agendamentoRepository.existsById(idagendamento);
    }

}
