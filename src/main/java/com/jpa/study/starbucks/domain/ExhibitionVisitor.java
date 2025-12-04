package com.jpa.study.starbucks.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
@Table(name = "exhibition_visitor")
@NoArgsConstructor
@AllArgsConstructor
public class ExhibitionVisitor {

    @EmbeddedId
    private ExhibitionVisitorId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("exhibitionId")
    @JoinColumn(name = "exhibition_id")
    private Exhibition exhibition;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("visitorId")
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @Column(name = "last_visit_date")
    private LocalDateTime lastVisitDate;
    @Column(name ="visit_count")
    private Integer visitCount;
    @Column(name = "register_datetime", insertable = false, updatable = false)
    private LocalDateTime registerDatetime;
    @Column(name = "modified_datetime", insertable = false, updatable = false)
    private LocalDateTime modifiedDatetime;

}
