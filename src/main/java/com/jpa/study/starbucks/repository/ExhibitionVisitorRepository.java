package com.jpa.study.starbucks.repository;

import com.jpa.study.starbucks.domain.ExhibitionVisitor;
import com.jpa.study.starbucks.domain.ExhibitionVisitorId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExhibitionVisitorRepository extends JpaRepository<ExhibitionVisitor, ExhibitionVisitorId> {

    List<ExhibitionVisitor> findByIdExhibitionId(Long exhibitionId);

    List<ExhibitionVisitor> findByIdVisitorId(String visitorId);

}
