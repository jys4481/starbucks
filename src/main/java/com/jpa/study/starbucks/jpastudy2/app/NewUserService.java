package com.jpa.study.starbucks.jpastudy2.app;

import com.jpa.study.starbucks.jpastudy2.User;
import com.jpa.study.starbucks.jpastudy2.jpa.EMF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * EntityManager #persist(Object entity)
 */
public class NewUserService {

    public void saveNewUser(User user) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            /**
             * persist를 통한 객체 DB 저장
             */
            em.persist(user);
            tx.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }

    }

}
