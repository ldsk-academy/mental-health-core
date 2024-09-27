package br.com.mh.mental_health_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mh.mental_health_core.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
