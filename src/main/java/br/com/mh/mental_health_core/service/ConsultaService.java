package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.ConsultaNotFoundException;
import br.com.mh.mental_health_core.model.Consulta;
import br.com.mh.mental_health_core.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta getConsultaById(Integer id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new ConsultaNotFoundException("Consulta não encontrada com ID: " + id));
    }

    public Consulta saveConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void deleteConsulta(Integer id) {
        consultaRepository.findById(id).orElseThrow(() -> new ConsultaNotFoundException("Consulta não encontrada com ID: " + id));
        consultaRepository.deleteById(id);
    }
}
