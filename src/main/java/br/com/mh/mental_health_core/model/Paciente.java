package br.com.mh.mental_health_core.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cpf;
    private Double idade;
    private String nomeCompleto;
    private String numeroTelefone;

    // Um paciente possui Uma ficha 
    @OneToOne(mappedBy = "paciente") 
    private Ficha ficha;

    // Um paciente pode marcar Muitas consultas
    @OneToMany(mappedBy = "paciente") 
    private List<Consulta> consultas = new ArrayList<>();


    
    
}
