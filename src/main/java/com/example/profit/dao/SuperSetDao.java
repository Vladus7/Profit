package com.example.profit.dao;

import com.example.profit.models.SuperSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class SuperSetDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void create(SuperSet set) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(set);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            System.out.println(e);
//            LOGGER.log(Level.ERROR, e);
//            throw new TransactionException(e);
        }
    }

    public List<SuperSet> findAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<SuperSet> criteria = builder.createQuery(SuperSet.class);
            criteria.select(criteria.from(SuperSet.class));
            return session.createQuery(criteria).getResultList();
        }
    }

    public SuperSet findByLogin(Long id) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<SuperSet> criteria = builder.createQuery(SuperSet.class);
            Root<SuperSet> root = criteria.from(SuperSet.class);
            criteria.where(
                    builder.equal(root.get("id"), id)
            );
            return session.createQuery(criteria).uniqueResult();
        }
    }
}
