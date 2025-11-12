package com.jpa.study.starbucks.jpastudy2.app;

import com.jpa.study.starbucks.jpastudy2.User2;
import com.jpa.study.starbucks.jpastudy2.jpa.EMF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * 트랜잭션 범위 내에서 변경된 값을 자동 반영
 */
public class ChangeNameService {

    public void changeName(String email, String newName) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            User2 user = em.find(User2.class, email);
            if (user == null) {
                throw new NoUserException();
            }
            user.changeName(newName);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }

    }

}
