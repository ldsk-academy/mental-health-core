package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.MentalHealthException;
import br.com.mh.mental_health_core.model.Psicologo;
import br.com.mh.mental_health_core.repository.PsicologoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsicologoService {

    private final PsicologoRepository psicologoRepository;

    public PsicologoService(PsicologoRepository psicologoRepository) {
        this.psicologoRepository = psicologoRepository;
    }

    public List<Psicologo> getAllPsicologos() {
        return psicologoRepository.findAll();
    }

    public Psicologo getPsicologoById(Integer id) {
        return psicologoRepository.findById(id)
                .orElseThrow(() -> new MentalHealthException(
                        HttpStatus.NOT_FOUND, 
                        "Psicólogo não encontrado com ID: " + id
                ));
    }

    public Psicologo savePsicologo(Psicologo psicologo) {
        return psicologoRepository.save(psicologo);
    }

    public void deletePsicologo(Integer id) {
        if (!psicologoRepository.existsById(id)) {
            throw new MentalHealthException(
                    HttpStatus.NOT_FOUND, 
                    "Psicólogo não encontrado com ID: " + id
            );
        }
        psicologoRepository.deleteById(id);
    }
}
