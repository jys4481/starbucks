package com.jpa.study.starbucks.service;

import com.jpa.study.starbucks.domain.Visitor;
import com.jpa.study.starbucks.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public Visitor getVisitor(String visitorId) {
        return visitorRepository.findById(visitorId).orElse(null);
    }

    @Transactional
    public Visitor saveVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

}
