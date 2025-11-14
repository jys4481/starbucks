package com.jpa.study.starbucks.jpastudy3.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMF {

    private static EntityManagerFactory emf;

    /**
     * 초기화
     */
    public static void init() {
        emf = Persistence.createEntityManagerFactory("jpabegin");
    }

    /**
     * EntityManager 생성
     */
    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * 종료
     */
    public static void close() {
        emf.close();
    }
}