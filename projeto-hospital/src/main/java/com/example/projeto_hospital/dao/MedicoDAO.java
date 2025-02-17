package com.example.projeto_hospital.dao;

import com.example.projeto_hospital.model.Medico;
import java.util.List;

public interface MedicoDAO {
    void save(Medico medico); // Método para salvar um médico no banco de dados.
    Medico findById(Long id); // Método para buscar um médico pelo ID.
    List<Medico> findAll(); // Método para listar todos os médicos.
    void update(Medico medico); // Método para atualizar um médico.
    void delete(Long id); // Método para deletar um médico pelo ID.
}
