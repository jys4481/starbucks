package com.jpa.study.starbucks.domain.main;

import jakarta.persistence.*;
import com.jpa.study.starbucks.domain.User;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
public class UserSaveMain {

    public static void main(String[] args) {

        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            User user = new User("user@user.com", "user", LocalDateTime.now());
            entityManager.persist(user);
            log.info("EntityManager.persist 호출");
            log.info("영속 컨텍스트에 저장");
            transaction.commit();
            log.info("EntityTransaction.commit 호출");
            log.info("commit이 되는 시점에 insert Query가 실행");
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
        */
    }

}
