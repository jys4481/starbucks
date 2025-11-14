package com.jpa.study.starbucks.jpastudy3.main;

import com.jpa.study.starbucks.jpastudy3.domain.Grade;
import com.jpa.study.starbucks.jpastudy3.domain.Hotel;
import com.jpa.study.starbucks.jpastudy3.jpa.EMF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {

    public static void main(String[] args) {

        EMF.init();

        Hotel entity = new Hotel("H-01", "신라호텔", 2025, Grade.S5);

        save(entity);
        Hotel hotel = read("H-01");
        if (hotel == null) {
            log.info("존재하지 않는 호텔입니다.");
        } else {
            log.info("존재하는 호텔이 있습니다.: {}", hotel);
        }

        EMF.close();
    }

    private static void save(Hotel entity) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    private static Hotel read(String id) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Hotel hotel = em.find(Hotel.class, id);
            tx.commit();
            return hotel;
        } catch (Exception ex) {
            /**
             * 단순 select문에서 rollback이 왜 필요한가?
             */
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

}
