package br.com.mh.mental_health_core.entities;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Disponibilidade {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private String diaSemana;

	    @ManyToOne
	    @JoinColumn(name = "psicologo_id")
	    private Psicologo psicologo;

	    
	    // Uma disponibilidade pode ter Muitos horários disponíveis
	    @OneToMany(mappedBy = "disponibilidade")
	    private List<HorarioDisponivel> horariosDisponiveis = new ArrayList<>();

	   
	    public Disponibilidade() {}

	  
	    public Disponibilidade(String diaSemana, Psicologo psicologo) {
	        this.diaSemana = diaSemana;
	        this.psicologo = psicologo;
	    }


	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getDiaSemana() {
	        return diaSemana;
	    }

	    public void setDiaSemana(String diaSemana) {
	        this.diaSemana = diaSemana;
	    }

	    public Psicologo getPsicologo() {
	        return psicologo;
	    }

	    public void setPsicologo(Psicologo psicologo) {
	        this.psicologo = psicologo;
	    }

	    public List<HorarioDisponivel> getHorariosDisponiveis() {
	        return horariosDisponiveis;
	    }

	    public void setHorariosDisponiveis(List<HorarioDisponivel> horariosDisponiveis) {
	        this.horariosDisponiveis = horariosDisponiveis;
	    }
}
