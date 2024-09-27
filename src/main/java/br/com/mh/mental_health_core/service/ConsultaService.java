package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.ResourceNotFoundException;
import br.com.mh.mental_health_core.model.Consulta;
import br.com.mh.mental_health_core.repository.ConsultaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    // CREATE
    public Consulta createConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    // READ
    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta getConsultaById(Integer id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));
    }

    // UPDATE
    public Consulta updateConsulta(Integer id, Consulta consultaDetails) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));

        consulta.setValor(consultaDetails.getValor());
        consulta.setData(consultaDetails.getData());
        consulta.setHorario(consultaDetails.getHorario());
        consulta.setNumeroTelefone(consultaDetails.getNumeroTelefone());
        
        return consultaRepository.save(consulta);
    }

    // DELETE
    public void deleteConsulta(Integer id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));
        consultaRepository.delete(consulta);
    }
}
