package br.com.mh.mental_health_core.entities;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

	public Consulta() {
	}

	public Consulta(Double valor, Date data, LocalTime horario, String numeroTelefone, Paciente paciente,
			Psicologo psicologo, Disponibilidade disponibilidade) {
		this.valor = valor;
		this.data = data;
		this.horario = horario;
		this.numeroTelefone = numeroTelefone;
		this.paciente = paciente;
		this.psicologo = psicologo;
		this.disponibilidade = disponibilidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Psicologo getPsicologo() {
		return psicologo;
	}

	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}

	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Disponibilidade disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
}
