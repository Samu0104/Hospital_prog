package com.example.projeto_hospital.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity // Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.
public class Medico {

    @Id // Indica que este campo é a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática do valor do ID.
    private Long id; // Campo que armazena o ID do médico.

    private String nome; // Campo que armazena o nome do médico.
    private String crm; // Campo que armazena o CRM do médico.
    private String especialidade; // Campo que armazena a especialidade do médico.

    @OneToMany(mappedBy = "medico") // Indica um relacionamento um-para-muitos com a entidade Paciente.
    private List<Paciente> pacientes; // Lista de pacientes associados a este médico.

    // Getters e Setters (métodos para acessar e modificar os campos)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setTelefone(String especialidade) {
        this.especialidade = especialidade;
    }
}