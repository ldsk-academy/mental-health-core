package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.ResourceNotFoundException;
import br.com.mh.mental_health_core.model.Especialidade;
import br.com.mh.mental_health_core.repository.EspecialidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    // CREATE
    public Especialidade createEspecialidade(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    // READ
    public List<Especialidade> getAllEspecialidades() {
        return especialidadeRepository.findAll();
    }

    public Especialidade getEspecialidadeById(Integer id) {
        return especialidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidade não encontrada com ID: " + id));
    }

    // UPDATE
    public Especialidade updateEspecialidade(Integer id, Especialidade especialidadeDetails) {
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidade não encontrada com ID: " + id));

        especialidade.setNome(especialidadeDetails.getNome());
        
        return especialidadeRepository.save(especialidade);
    }

    // DELETE
    public void deleteEspecialidade(Integer id) {
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidade não encontrada com ID: " + id));
        especialidadeRepository.delete(especialidade);
    }
}
