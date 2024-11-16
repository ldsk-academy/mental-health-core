package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.MentalHealthException;
import br.com.mh.mental_health_core.model.Especialidade;
import br.com.mh.mental_health_core.repository.EspecialidadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;

    public EspecialidadeService(EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    public List<Especialidade> getAllEspecialidades() {
        return especialidadeRepository.findAll();
    }

    public Especialidade getEspecialidadeById(Integer id) {
        return especialidadeRepository.findById(id)
                .orElseThrow(() -> new MentalHealthException(
                        HttpStatus.NOT_FOUND, 
                        "Especialidade não encontrada com ID: " + id
                ));
    }

    public Especialidade saveEspecialidade(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public void deleteEspecialidade(Integer id) {
        if (!especialidadeRepository.existsById(id)) {
            throw new MentalHealthException(
                    HttpStatus.NOT_FOUND, 
                    "Especialidade não encontrada com ID: " + id
            );
        }
        especialidadeRepository.deleteById(id);
    }
}
