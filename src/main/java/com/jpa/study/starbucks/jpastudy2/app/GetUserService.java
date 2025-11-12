package com.jpa.study.starbucks.jpastudy2.app;

import com.jpa.study.starbucks.jpastudy2.User2;
import com.jpa.study.starbucks.jpastudy2.jpa.EMF;
import jakarta.persistence.EntityManager;

/**
 * EntityManger #find(Class<T> entityClass, Object primaryKey)
 */
public class GetUserService {

    public User2 getUser(String email) {
        EntityManager em = EMF.createEntityManager();
        try {
            User2 user = em.find(User2.class, email);
            if (user == null) {
                throw new NoUserException();
            }
            return user;
        } finally {
            em.close();
        }
    }

}
