package com.example.profit.dao;

import com.example.profit.models.Workout;
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
public class WorkoutDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void create(Workout workout) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(workout);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            System.out.println(e);
//            LOGGER.log(Level.ERROR, e);
//            throw new TransactionException(e);
        }
    }

    public List<Workout> findAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Workout> criteria = builder.createQuery(Workout.class);
            criteria.select(criteria.from(Workout.class));
            return session.createQuery(criteria).getResultList();
        }
    }

    public Workout findByLogin(Long id) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Workout> criteria = builder.createQuery(Workout.class);
            Root<Workout> root = criteria.from(Workout.class);
            criteria.where(
                    builder.equal(root.get("id"), id)
            );
            return session.createQuery(criteria).uniqueResult();
        }
    }
}
