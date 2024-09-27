package br.com.mh.mental_health_core.model;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double valor;
	private Date data;
	private LocalTime horario;
	private String numeroTelefone;

	// Muitas consultas são marcadas por Um paciente 
	@ManyToOne 
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	// Muitas consultas são realizadas por Um psicologo 
	@ManyToOne 
	@JoinColumn(name = "psicologo_id")
	private Psicologo psicologo;

	// Muitas consultas fazem parte de Uma disponibilidade 
	@ManyToOne 
	@JoinColumn(name = "disponibilidade_id")
	private Disponibilidade disponibilidade;


}
