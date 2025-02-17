package com.example.projeto_hospital.dao;

import com.example.projeto_hospital.model.Paciente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Indica que esta classe é um repositório (componente de acesso a dados).
public class PacienteDAOImpl implements PacienteDAO {

    @Autowired // Injeta automaticamente uma instância de SessionFactory.
    private SessionFactory sessionFactory;

    @Override
    public void save(Paciente paciente) {
        Session session = sessionFactory.getCurrentSession(); // Obtém a sessão atual do Hibernate.
        if (paciente.getId() == null) {
            session.persist(paciente); // Salva um novo paciente no banco de dados.
        } else {
            session.merge(paciente); // Atualiza um paciente existente no banco de dados.
        }
    }

    @Override
    public Paciente findById(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Obtém a sessão atual do Hibernate.
        return session.get(Paciente.class, id); // Busca o paciente pelo ID.
    }

    @Override
    public List<Paciente> findAll() {
        Session session = sessionFactory.getCurrentSession(); // Obtém a sessão atual do Hibernate.
        return session.createQuery("from Paciente", Paciente.class).getResultList(); // Lista todos os pacientes.
    }

    @Override
    public void update(Paciente paciente) {
        Session session = sessionFactory.getCurrentSession(); // Obtém a sessão atual do Hibernate.
        session.merge(paciente); // Atualiza o paciente no banco de dados.
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Obtém a sessão atual do Hibernate.
        Paciente paciente = session.get(Paciente.class, id); // Busca o paciente pelo ID.
        if (paciente != null) {
            session.remove(paciente); // Deleta o paciente do banco de dados.
        }
    }
}