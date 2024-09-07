package br.com.mh.mental_health_core.entities;

import br.com.mh.mental_health_core.enums.StatusPaciente;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String anotacoes;

    @Enumerated(EnumType.STRING) 
    private StatusPaciente statusPaciente;

    private String historicoFamiliar;

    // Uma ficha pertence a Um paciente
    @OneToOne
    @JoinColumn(name = "paciente_id") 
    private Paciente paciente;

 
    public Ficha() {}

    public Ficha(String anotacoes, StatusPaciente statusPaciente, String historicoFamiliar, Paciente paciente) {
        this.anotacoes = anotacoes;
        this.statusPaciente = statusPaciente;
        this.historicoFamiliar = historicoFamiliar;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public StatusPaciente getStatusPaciente() {
        return statusPaciente;
    }

    public void setStatusPaciente(StatusPaciente statusPaciente) {
        this.statusPaciente = statusPaciente;
    }

    public String getHistoricoFamiliar() {
        return historicoFamiliar;
    }

    public void setHistoricoFamiliar(String historicoFamiliar) {
        this.historicoFamiliar = historicoFamiliar;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
