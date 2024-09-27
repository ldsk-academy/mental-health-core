package br.com.mh.mental_health_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mh.mental_health_core.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}