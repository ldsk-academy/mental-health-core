package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.ResourceNotFoundException;
import br.com.mh.mental_health_core.model.Disponibilidade;
import br.com.mh.mental_health_core.repository.DisponibilidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadeService {

    @Autowired
    private DisponibilidadeRepository disponibilidadeRepository;

    // CREATE
    public Disponibilidade createDisponibilidade(Disponibilidade disponibilidade) {
        return disponibilidadeRepository.save(disponibilidade);
    }

    // READ
    public List<Disponibilidade> getAllDisponibilidades() {
        return disponibilidadeRepository.findAll();
    }

    public Disponibilidade getDisponibilidadeById(Integer id) {
        return disponibilidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disponibilidade não encontrada com ID: " + id));
    }

    // UPDATE
    public Disponibilidade updateDisponibilidade(Integer id, Disponibilidade disponibilidadeDetails) {
        Disponibilidade disponibilidade = disponibilidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disponibilidade não encontrada com ID: " + id));

        disponibilidade.setDiaSemana(disponibilidadeDetails.getDiaSemana());
        
        return disponibilidadeRepository.save(disponibilidade);
    }

    // DELETE
    public void deleteDisponibilidade(Integer id) {
        Disponibilidade disponibilidade = disponibilidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disponibilidade não encontrada com ID: " + id));
        disponibilidadeRepository.delete(disponibilidade);
    }
}
