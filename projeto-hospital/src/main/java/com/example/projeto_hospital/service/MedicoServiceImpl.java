package com.example.projeto_hospital.service;

import com.example.projeto_hospital.dao.MedicoDAO;
import com.example.projeto_hospital.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indica que esta classe é um serviço (componente de lógica de negócio).
public class MedicoServiceImpl implements MedicoService {

    @Autowired // Injeta automaticamente uma instância de MedicoDAO.
    private MedicoDAO medicoDAO;

    @Override
    public void save(Medico medico) {
        medicoDAO.save(medico); // Chama o método save do DAO.
    }

    @Override
    public Medico findById(Long id) {
        return medicoDAO.findById(id); // Chama o método findById do DAO.
    }

    @Override
    public List<Medico> findAll() {
        return medicoDAO.findAll(); // Chama o método findAll do DAO.
    }

    @Override
    public void update(Medico medico) {
        medicoDAO.update(medico); // Chama o método update do DAO.
    }

    @Override
    public void delete(Long id) {
        medicoDAO.delete(id); // Chama o método delete do DAO.
    }
}