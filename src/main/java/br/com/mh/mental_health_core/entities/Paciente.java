package br.com.mh.mental_health_core.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

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

    public Paciente() {
    }

    public Paciente(String cpf, Double idade, String nomeCompleto, String numeroTelefone) {
        this.cpf = cpf;
        this.idade = idade;
        this.nomeCompleto = nomeCompleto;
        this.numeroTelefone = numeroTelefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIdade() {
        return idade;
    }

    public void setIdade(Double idade) {
        this.idade = idade;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
