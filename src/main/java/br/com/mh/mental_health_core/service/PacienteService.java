package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.ResourceNotFoundException;
import br.com.mh.mental_health_core.model.Paciente;
import br.com.mh.mental_health_core.repository.PacienteRepository;

import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente getPacienteById(Integer id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com ID: " + id));
    }

    public Paciente updatePaciente(Integer id, Paciente paciente) {
        if (!pacienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Paciente não encontrado com ID: " + id);
        }
        paciente.setId(id);
        return pacienteRepository.save(paciente);
    }

    public void deletePaciente(Integer id) {
        if (!pacienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Paciente não encontrado com ID: " + id);
        }
        pacienteRepository.deleteById(id);
    }
}
