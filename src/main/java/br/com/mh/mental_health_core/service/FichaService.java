package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.MentalHealthException;
import br.com.mh.mental_health_core.model.Ficha;
import br.com.mh.mental_health_core.repository.FichaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaService {

    private final FichaRepository fichaRepository;

    public FichaService(FichaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;
    }

    public List<Ficha> getAllFichas() {
        return fichaRepository.findAll();
    }

    public Ficha getFichaById(Integer id) {
        return fichaRepository.findById(id)
                .orElseThrow(() -> new MentalHealthException(
                        HttpStatus.NOT_FOUND, 
                        "Ficha não encontrada com ID: " + id
                ));
    }

    public Ficha saveFicha(Ficha ficha) {
        return fichaRepository.save(ficha);
    }

    public void deleteFicha(Integer id) {
        if (!fichaRepository.existsById(id)) {
            throw new MentalHealthException(
                    HttpStatus.NOT_FOUND, 
                    "Ficha não encontrada com ID: " + id
            );
        }
        fichaRepository.deleteById(id);
    }
}
