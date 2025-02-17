package com.example.projeto_hospital.dao;

import com.example.projeto_hospital.model.Paciente;
import java.util.List;

public interface PacienteDAO {
    void save(Paciente paciente); // Método para salvar um paciente no banco de dados.
    Paciente findById(Long id); // Método para buscar um paciente pelo ID.
    List<Paciente> findAll(); // Método para listar todos os pacientes.
    void update(Paciente paciente); // Método para atualizar um paciente.
    void delete(Long id); // Método para deletar um paciente pelo ID.
}