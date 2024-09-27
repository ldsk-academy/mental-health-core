package br.com.mh.mental_health_core.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Psicologo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String cpf;
	private String crp;
	private String nomeCompleto;
	private String numeroTelefone;

	// Um psicologo pode realizar Muitas consultas
	@OneToMany(mappedBy = "psicologo")
	private List<Consulta> consultas = new ArrayList<>();

	// Um psicologo pode ter Muitas disponibilidades.
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "horario_disponivel", joinColumns = @JoinColumn(name = "psicologo_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "disponibilidade_id", referencedColumnName = "id"))
	private List<Disponibilidade> disponibilidades = new ArrayList<>();
	
	
	// Um psicologo pode ter Muitas especialidades
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "psicologo_especialidade", joinColumns = @JoinColumn(name = "psicologo_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "especialidade_id", referencedColumnName = "id"))
	private List<Especialidade> especialidades = new ArrayList<>();

}
