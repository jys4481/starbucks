package com.jpa.study.starbucks.service;

import com.jpa.study.starbucks.domain.Exhibition;
import com.jpa.study.starbucks.repository.ExhibitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ExhibitionService {

    @Autowired
    ExhibitionRepository exhibitionRepository;

    public List<Exhibition> getAllExhibitions() {
        return exhibitionRepository.findAll();
    }

    public Exhibition getExhibition(Long exhibitionId) {
        return exhibitionRepository.findById(exhibitionId).orElse(null);
    }

    @Transactional
    public Exhibition saveExhibition(Exhibition exhibition) {
        return exhibitionRepository.save(exhibition);
    }

    @Transactional
    public Exhibition updateExhibition(Long exhibitionId, Exhibition updateExhibition) {
        Exhibition exhibition = getExhibition(exhibitionId);
        exhibition.setTitle(updateExhibition.getTitle());
        exhibition.setContents(updateExhibition.getContents());
        exhibition.setBeginDate(updateExhibition.getBeginDate());
        exhibition.setEndDate(updateExhibition.getEndDate());
        return exhibitionRepository.save(exhibition);
    }

    @Transactional
    public void deleteExhibition(Long exhibitionId) {
        exhibitionRepository.deleteById(exhibitionId);
    }

}
