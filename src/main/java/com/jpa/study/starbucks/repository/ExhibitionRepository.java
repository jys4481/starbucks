package com.jpa.study.starbucks.repository;

import com.jpa.study.starbucks.domain.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {
}
