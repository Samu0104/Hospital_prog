package com.example.projeto_hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity // Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.
public class Paciente {

    @Id // Indica que este campo é a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática do valor do ID.
    private Long id; // Campo que armazena o ID do paciente.

    private String nome; // Campo que armazena o nome do paciente.
    private String cpf; // Campo que armazena o CPF do paciente.
    private String telefone; // Campo que armazena o telefone do paciente.

    @ManyToOne // Indica um relacionamento muitos-para-um com a entidade Medico.
    @JoinColumn(name = "medico_id") // Define a coluna de chave estrangeira na tabela Paciente.
    private Medico medico; // Campo que armazena o médico responsável pelo paciente.

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}