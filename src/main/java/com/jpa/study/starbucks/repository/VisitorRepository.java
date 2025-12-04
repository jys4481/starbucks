package com.jpa.study.starbucks.repository;

import com.jpa.study.starbucks.domain.Exhibition;
import com.jpa.study.starbucks.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, String> {

}
