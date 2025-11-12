package com.jpa.study.starbucks.jpastudy2.app;

import com.jpa.study.starbucks.jpastudy2.User2;
import com.jpa.study.starbucks.jpastudy2.jpa.EMF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * EntityManager #remove(Object entity)
 */
public class RemoveUserService {

    public void removeUser(String email) {

        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            User2 user = em.find(User2.class, email);
            if (user == null) {
                throw new NoUserException();
            }
            /**
             * find로 읽어온 객체를 전달해야 삭제가 진행된다.
             * find로 읽어오지 않은 객체를 전달할 경우 Error 발생
             * transaction 범위 밖에서 remove에 전달할 경우 온전하게 실행이 되지 않는 Error 발생
             */
            em.remove(user);
            /**
             * remove와 commit 사이 시점에서
             * 다른 프로세스가 데이터를 삭제할 경우 Exception이 발생한다.
             */
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }

    }

}
