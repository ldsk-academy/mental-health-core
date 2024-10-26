package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.DisponibilidadeNotFoundException;
import br.com.mh.mental_health_core.model.Disponibilidade;
import br.com.mh.mental_health_core.repository.DisponibilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadeService {

    @Autowired
    private DisponibilidadeRepository disponibilidadeRepository;

    public List<Disponibilidade> getAllDisponibilidades() {
        return disponibilidadeRepository.findAll();
    }

    public Disponibilidade getDisponibilidadeById(Integer id) {
        return disponibilidadeRepository.findById(id)
                .orElseThrow(() -> new DisponibilidadeNotFoundException("Disponibilidade não encontrada com ID: " + id));
    }

    public Disponibilidade saveDisponibilidade(Disponibilidade disponibilidade) {
        return disponibilidadeRepository.save(disponibilidade);
    }

    public void deleteDisponibilidade(Integer id) {
        disponibilidadeRepository.findById(id).orElseThrow(() -> new DisponibilidadeNotFoundException("Disponibilidade não encontrada com ID: " + id));
        disponibilidadeRepository.deleteById(id);
    }
}
