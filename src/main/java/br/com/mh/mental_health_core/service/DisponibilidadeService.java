package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.MentalHealthException;
import br.com.mh.mental_health_core.model.Disponibilidade;
import br.com.mh.mental_health_core.repository.DisponibilidadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadeService {

    private final DisponibilidadeRepository disponibilidadeRepository;

    public DisponibilidadeService(DisponibilidadeRepository disponibilidadeRepository) {
        this.disponibilidadeRepository = disponibilidadeRepository;
    }

    public List<Disponibilidade> getAllDisponibilidades() {
        return disponibilidadeRepository.findAll();
    }

    public Disponibilidade getDisponibilidadeById(Integer id) {
        return disponibilidadeRepository.findById(id)
                .orElseThrow(() -> new MentalHealthException(
                        HttpStatus.NOT_FOUND, 
                        "Disponibilidade não encontrada com ID: " + id
                ));
    }

    public Disponibilidade saveDisponibilidade(Disponibilidade disponibilidade) {
        return disponibilidadeRepository.save(disponibilidade);
    }

    public void deleteDisponibilidade(Integer id) {
        if (!disponibilidadeRepository.existsById(id)) {
            throw new MentalHealthException(
                    HttpStatus.NOT_FOUND, 
                    "Disponibilidade não encontrada com ID: " + id
            );
        }
        disponibilidadeRepository.deleteById(id);
    }
}
