package com.example.projeto_hospital.dao;

import com.example.projeto_hospital.model.Medico;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Indica que esta classe é um repositório (componente de acesso a dados).
public class MedicoDAOImpl implements MedicoDAO {

    @Autowired // Injeta automaticamente uma instância de SessionFactory.
    private SessionFactory sessionFactory;

    @Override
    public void save(Medico medico) {
        Session session = sessionFactory.getCurrentSession(); // Obtém a sessão atual do Hibernate.
        if (medico.getId() == null) {
            session.persist(medico); // Salva um novo médico no banco de dados.
        } else {
            session.merge(medico); // Atualiza um médico existente no banco de dados.
        }
    }

    @Override
    public Medico findById(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Obtém a sessão atual do Hibernate.
        return session.get(Medico.class, id); // Busca o médico pelo ID.
    }

    @Override
    public List<Medico> findAll() {
        Session session = sessionFactory.getCurrentSession(); // Obtém a sessão atual do Hibernate.
        return session.createQuery("from Medico", Medico.class).getResultList(); // Lista todos os médicos.
    }

    @Override
    public void update(Medico medico) {
        Session session = sessionFactory.getCurrentSession(); // Obtém a sessão atual do Hibernate.
        session.merge(medico); // Atualiza o médico no banco de dados.
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Obtém a sessão atual do Hibernate.
        Medico medico = session.get(Medico.class, id); // Busca o médico pelo ID.
        if (medico != null) {
            session.remove(medico); // Deleta o médico do banco de dados.
        }
    }
}