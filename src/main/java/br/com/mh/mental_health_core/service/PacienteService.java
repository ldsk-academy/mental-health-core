package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.PacienteNotFoundException;
import br.com.mh.mental_health_core.model.Paciente;
import br.com.mh.mental_health_core.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(Integer id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException("Paciente não encontrado com ID: " + id));
    }

    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deletePaciente(Integer id) {
        pacienteRepository.findById(id).orElseThrow(() -> new PacienteNotFoundException("Paciente não encontrado com ID: " + id));
        pacienteRepository.deleteById(id);
    }
}
