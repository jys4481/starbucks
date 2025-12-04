package com.jpa.study.starbucks.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
@Table(name = "exhibition")
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long exhibitionId;
    private String title;
    private String contents;
    @Column(name = "begin_date")
    private LocalDateTime beginDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "register_datetime", insertable = false, updatable = false)
    private LocalDateTime registerDatetime;
    @Column(name ="modified_datetime", insertable = false, updatable = false)
    private LocalDateTime modifiedDatetime;

}
