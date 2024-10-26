package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.EspecialidadeNotFoundException;
import br.com.mh.mental_health_core.model.Especialidade;
import br.com.mh.mental_health_core.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public List<Especialidade> getAllEspecialidades() {
        return especialidadeRepository.findAll();
    }

    public Especialidade getEspecialidadeById(Integer id) {
        return especialidadeRepository.findById(id)
                .orElseThrow(() -> new EspecialidadeNotFoundException("Especialidade não encontrada com ID: " + id));
    }

    public Especialidade saveEspecialidade(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public void deleteEspecialidade(Integer id) {
        especialidadeRepository.findById(id).orElseThrow(() -> new EspecialidadeNotFoundException("Especialidade não encontrada com ID: " + id));
        especialidadeRepository.deleteById(id);
    }
}
