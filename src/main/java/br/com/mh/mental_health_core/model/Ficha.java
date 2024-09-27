package br.com.mh.mental_health_core.model;

import br.com.mh.mental_health_core.enums.StatusPaciente;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import jakarta.persistence.JoinColumn;
@Data
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


}
