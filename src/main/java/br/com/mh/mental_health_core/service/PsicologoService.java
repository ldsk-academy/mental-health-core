package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.PsicologoNotFoundException;
import br.com.mh.mental_health_core.model.Psicologo;
import br.com.mh.mental_health_core.repository.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsicologoService {

    @Autowired
    private PsicologoRepository psicologoRepository;

    public List<Psicologo> getAllPsicologos() {
        return psicologoRepository.findAll();
    }

    public Psicologo getPsicologoById(Integer id) {
        return psicologoRepository.findById(id)
                .orElseThrow(() -> new PsicologoNotFoundException("Psicólogo não encontrado com ID: " + id));
    }

    public Psicologo savePsicologo(Psicologo psicologo) {
        return psicologoRepository.save(psicologo);
    }

    public void deletePsicologo(Integer id) {
        psicologoRepository.findById(id).orElseThrow(() -> new PsicologoNotFoundException("Psicólogo não encontrado com ID: " + id));
        psicologoRepository.deleteById(id);
    }
}
