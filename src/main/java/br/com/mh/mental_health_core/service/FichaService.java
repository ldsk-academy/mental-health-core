package br.com.mh.mental_health_core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mh.mental_health_core.exceptions.ResourceNotFoundException;
import br.com.mh.mental_health_core.model.Ficha;
import br.com.mh.mental_health_core.repository.FichaRepository;

@Service
public class FichaService {

    @Autowired
    private FichaRepository fichaRepository;

    // CREATE
    public Ficha createFicha(Ficha ficha) {
        return fichaRepository.save(ficha);
    }

    // READ
    public List<Ficha> getAllFichas() {
        return fichaRepository.findAll();
    }

    public Ficha getFichaById(Integer id) {
        return fichaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ficha não encontrada com ID: " + id));
    }

    // UPDATE
    public Ficha updateFicha(Integer id, Ficha fichaDetails) {
        Ficha ficha = fichaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ficha não encontrada com ID: " + id));

        ficha.setAnotacoes(fichaDetails.getAnotacoes());
        ficha.setStatusPaciente(fichaDetails.getStatusPaciente());
        ficha.setHistoricoFamiliar(fichaDetails.getHistoricoFamiliar());
        
        return fichaRepository.save(ficha);
    }

    // DELETE
    public void deleteFicha(Integer id) {
        Ficha ficha = fichaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ficha não encontrada com ID: " + id));
        fichaRepository.delete(ficha);
    }
}
