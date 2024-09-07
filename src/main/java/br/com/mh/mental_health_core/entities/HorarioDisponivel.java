package br.com.mh.mental_health_core.entities;

import java.time.LocalTime;

import br.com.mh.mental_health_core.enums.StatusHorario;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HorarioDisponivel {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private LocalTime horario;

	    @Enumerated(EnumType.STRING)
	    private StatusHorario status;

	    // Muitos horários disponíveis estão associados a Uma disponibilidade
	    @ManyToOne 
	    @JoinColumn(name = "disponibilidade_id")
	    private Disponibilidade disponibilidade;

	    public HorarioDisponivel() {}

	  
	    public HorarioDisponivel(LocalTime horario, StatusHorario status, Disponibilidade disponibilidade) {
	        this.horario = horario;
	        this.status = status;
	        this.disponibilidade = disponibilidade;
	    }

	  
	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public LocalTime getHorario() {
	        return horario;
	    }

	    public void setHorario(LocalTime horario) {
	        this.horario = horario;
	    }

	    public StatusHorario getStatus() {
	        return status;
	    }

	    public void setStatus(StatusHorario status) {
	        this.status = status;
	    }

	    public Disponibilidade getDisponibilidade() {
	        return disponibilidade;
	    }

	    public void setDisponibilidade(Disponibilidade disponibilidade) {
	        this.disponibilidade = disponibilidade;
	    }
	    
}
