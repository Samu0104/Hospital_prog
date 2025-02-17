package com.example.projeto_hospital.service;

import com.example.projeto_hospital.dao.PacienteDAO;
import com.example.projeto_hospital.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indica que esta classe é um serviço (componente de lógica de negócio).
public class PacienteServiceImpl implements PacienteService {

    @Autowired // Injeta automaticamente uma instância de PacienteDAO.
    private PacienteDAO pacienteDAO;

    @Override
    public void save(Paciente paciente) {
        pacienteDAO.save(paciente); // Chama o método save do DAO.
    }

    @Override
    public Paciente findById(Long id) {
        return pacienteDAO.findById(id); // Chama o método findById do DAO.
    }

    @Override
    public List<Paciente> findAll() {
        return pacienteDAO.findAll(); // Chama o método findAll do DAO.
    }

    @Override
    public void update(Paciente paciente) {
        pacienteDAO.update(paciente); // Chama o método update do DAO.
    }

    @Override
    public void delete(Long id) {
        pacienteDAO.delete(id); // Chama o método delete do DAO.
    }
}