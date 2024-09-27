package br.com.mh.mental_health_core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mh.mental_health_core.exceptions.ResourceNotFoundException;
import br.com.mh.mental_health_core.model.Psicologo;
import br.com.mh.mental_health_core.repository.PsicologoRepository;

@Service
public class PsicologoService {

    @Autowired
    private PsicologoRepository psicologoRepository;

    // CREATE
    public Psicologo createPsicologo(Psicologo psicologo) {
        return psicologoRepository.save(psicologo);
    }

    // READ
    public List<Psicologo> getAllPsicologos() {
        return psicologoRepository.findAll();
    }

    public Psicologo getPsicologoById(Integer id) {
        return psicologoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Psicologo não encontrado com ID: " + id));
    }

    // UPDATE
    public Psicologo updatePsicologo(Integer id, Psicologo psicologoDetails) {
        Psicologo psicologo = psicologoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Psicologo não encontrado com ID: " + id));

        psicologo.setCpf(psicologoDetails.getCpf());
        psicologo.setCrp(psicologoDetails.getCrp());
        psicologo.setNomeCompleto(psicologoDetails.getNomeCompleto());
        psicologo.setNumeroTelefone(psicologoDetails.getNumeroTelefone());
        
        return psicologoRepository.save(psicologo);
    }

    // DELETE
    public void deletePsicologo(Integer id) {
        Psicologo psicologo = psicologoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Psicologo não encontrado com ID: " + id));
        psicologoRepository.delete(psicologo);
    }
}
