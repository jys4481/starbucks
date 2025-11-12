package com.jpa.study.starbucks.jpastudy2.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * EntityManagerFactory 보조 클래스
 */
public class EMF {

    private static EntityManagerFactory emf;

    /**
     * 초기화
     */
    public static void init() {
        emf = Persistence.createEntityManagerFactory("jpabegin");
    }

    /**
     * EntityManger가 필요한 경우를 위해 생성
     */
    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }

}
