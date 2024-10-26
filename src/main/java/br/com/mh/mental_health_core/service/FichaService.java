package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.FichaNotFoundException;
import br.com.mh.mental_health_core.model.Ficha;
import br.com.mh.mental_health_core.repository.FichaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaService {

    @Autowired
    private FichaRepository fichaRepository;

    public List<Ficha> getAllFichas() {
        return fichaRepository.findAll();
    }

    public Ficha getFichaById(Integer id) {
        return fichaRepository.findById(id)
                .orElseThrow(() -> new FichaNotFoundException("Ficha não encontrada com ID: " + id));
    }

    public Ficha saveFicha(Ficha ficha) {
        return fichaRepository.save(ficha);
    }

    public void deleteFicha(Integer id) {
        fichaRepository.findById(id).orElseThrow(() -> new FichaNotFoundException("Ficha não encontrada com ID: " + id));
        fichaRepository.deleteById(id);
    }
}
