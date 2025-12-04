package com.jpa.study.starbucks.controller;

import com.jpa.study.starbucks.domain.Exhibition;
import com.jpa.study.starbucks.domain.Visitor;
import com.jpa.study.starbucks.service.ExhibitionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Starbucks JPA
 * Exhibition(전시)
 * CRUD
 */
@RestController
@RequestMapping("/exhibitions")
@Log4j2
public class ExhibitionController {

    @Autowired
    ExhibitionService exhibitionService;

    @GetMapping
    public ResponseEntity<List<Exhibition>> getAllExhibitions() {
        return ResponseEntity.ok(exhibitionService.getAllExhibitions());
    }

    @GetMapping("/{exhibitionId}")
    public ResponseEntity<Exhibition> getExhibition(@PathVariable Long exhibitionId) {
        return ResponseEntity.ok(exhibitionService.getExhibition(exhibitionId));
    }

    @PostMapping
    public ResponseEntity<Exhibition> saveExhibition(@RequestBody Exhibition exhibition) {
        exhibitionService.saveExhibition(exhibition);
        return ResponseEntity.status(HttpStatus.CREATED).body(exhibition);
    }

    @PutMapping("/{exhibitionId}")
    public ResponseEntity<Exhibition> updateExhibition(
            @PathVariable Long exhibitionId,
            @RequestBody Exhibition exhibition) {
        return ResponseEntity.ok(exhibitionService.updateExhibition(exhibitionId, exhibition));
    }

    @DeleteMapping("/{exhibitionId}")
    public ResponseEntity<Void> deleteExhibion(@PathVariable Long exhibitionId) {
        exhibitionService.deleteExhibition(exhibitionId);
        return ResponseEntity.noContent().build();
    }



}
