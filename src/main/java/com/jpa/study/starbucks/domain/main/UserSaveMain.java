package com.jpa.study.starbucks.domain.main;

import jakarta.persistence.*;
import com.jpa.study.starbucks.domain.User;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
public class UserSaveMain {

    public static void main(String[] args) {


        /**
         * jpabegin Parameter → persistence.xml에서
         * <persistence-unit name="jpabegin"
         * ☞ 위 정의한 영속 단위 기준으로 초기화.
         * ☞ 필요한 자원을 생성한다.
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        /* EntityManager 생성 */
        EntityManager entityManager = emf.createEntityManager();
        /* EntityTransaction 구함 */
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            /* 트랜잭션 시작 */
            transaction.begin();
            User user = new User("user@user.com", "user", LocalDateTime.now());
            /**
             * ☞ persists → Parmeter로 전달한 Object가 DB에 저장
             * ☞ .. entityManger로 DB 작업
             */
            entityManager.persist(user);
            log.info("EntityManager.persist 호출");
            log.info("영속 컨텍스트에 저장");
            /* 트랜잭션 커밋 */
            transaction.commit();
            log.info("EntityTransaction.commit 호출");
            log.info("commit이 되는 시점에 insert Query가 실행");
        } catch (Exception ex) {
            ex.printStackTrace();
            /* 트랜잭션 롤백 */
            transaction.rollback();
        } finally {
            /* EntityManger close */
            entityManager.close();
        }
        /**
         * ☞ 팩토리 닫음
         * ☞ 사용한 자원 반환
         */
        emf.close();
    }

}
