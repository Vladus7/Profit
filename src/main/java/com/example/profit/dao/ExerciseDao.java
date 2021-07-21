package com.example.profit.dao;

import com.example.profit.models.Exercise;
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
public class ExerciseDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void create(Exercise exercise) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(exercise);
            transaction.commit();
        } catch (RuntimeException e) {
            System.out.println(e);
            transaction.rollback();
//            LOGGER.log(Level.ERROR, e);
//            throw new TransactionException(e);
        }
    }

    public List<Exercise> findAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Exercise> criteria = builder.createQuery(Exercise.class);
            criteria.select(criteria.from(Exercise.class));
            return session.createQuery(criteria).getResultList();
        }
    }

    public Exercise findByLogin(Long id) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Exercise> criteria = builder.createQuery(Exercise.class);
            Root<Exercise> root = criteria.from(Exercise.class);
            criteria.where(
                    builder.equal(root.get("id"), id)
            );
            return session.createQuery(criteria).uniqueResult();
        }
    }
}
