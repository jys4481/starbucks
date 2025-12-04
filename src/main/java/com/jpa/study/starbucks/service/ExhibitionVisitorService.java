package com.jpa.study.starbucks.service;

import com.jpa.study.starbucks.domain.Exhibition;
import com.jpa.study.starbucks.domain.ExhibitionVisitor;
import com.jpa.study.starbucks.domain.ExhibitionVisitorId;
import com.jpa.study.starbucks.domain.Visitor;
import com.jpa.study.starbucks.repository.ExhibitionRepository;
import com.jpa.study.starbucks.repository.ExhibitionVisitorRepository;
import com.jpa.study.starbucks.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ExhibitionVisitorService {

    private final ExhibitionVisitorRepository exhibitionVisitorRepository;
    private final ExhibitionRepository exhibitionRepository;
    private final VisitorRepository visitorRepository;

    @Transactional
    public ExhibitionVisitor saveExhibitionVisitor(Long exhibitionId, String visitorId) {

        Exhibition exhibition = exhibitionRepository.findById(exhibitionId)
                .orElseThrow(() -> new RuntimeException("전시가 존재하지 않습니다."));

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("방문자가 존재하지 않습니다."));

        // 복합키 구성
        ExhibitionVisitorId id = new ExhibitionVisitorId(exhibitionId, visitorId);

        // 기존 방문 기록 조회
        ExhibitionVisitor exhibitionVisitor = exhibitionVisitorRepository.findById(id)
                .orElseGet(() -> {
                    // 없으면 신규 생성
                    ExhibitionVisitor newEv = new ExhibitionVisitor();
                    newEv.setId(id);
                    newEv.setExhibition(exhibition);
                    newEv.setVisitor(visitor);
                    newEv.setVisitCount(0);
                    newEv.setRegisterDatetime(LocalDateTime.now());
                    return newEv;
                });

        // 방문 기록 업데이트 (공통)
        exhibitionVisitor.setLastVisitDate(LocalDateTime.now());
        exhibitionVisitor.setVisitCount(exhibitionVisitor.getVisitCount() + 1);
        exhibitionVisitor.setModifiedDatetime(LocalDateTime.now());

        // 저장
        return exhibitionVisitorRepository.save(exhibitionVisitor);
    }

}
