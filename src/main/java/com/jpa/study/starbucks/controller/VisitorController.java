package com.jpa.study.starbucks.controller;

import com.jpa.study.starbucks.domain.Visitor;
import com.jpa.study.starbucks.service.VisitorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Starbucks JPA
 * Visitor(방문객)
 * CRUD
 */
@RestController
@RequestMapping("/visitors")
@Log4j2
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @GetMapping
    public ResponseEntity<List<Visitor>> getAllVisitors() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }

    @GetMapping("/{visitorId}")
    public ResponseEntity<Visitor> getVisitor(@PathVariable String visitorId) {
        return  ResponseEntity.ok(visitorService.getVisitor(visitorId));
    }

    @PostMapping
    public ResponseEntity<Visitor> saveVisitor(@RequestBody Visitor visitor) {
        visitorService.saveVisitor(visitor);
        return ResponseEntity.status(HttpStatus.CREATED).body(visitor);
    }

}
