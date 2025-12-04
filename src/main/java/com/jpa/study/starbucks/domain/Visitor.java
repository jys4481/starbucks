package com.jpa.study.starbucks.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
@Table(name = "visitor")
public class Visitor {

    @Id
    @Column(name = "visitor_id")
    private String visitorId;
    private String name;
    @Column(name = "birth_date")
    private LocalDateTime birthDate;
    @Column(name = "register_datetime", insertable = false, updatable = false)
    private LocalDateTime registerDatetime;
    @Column(name = "modified_datetime", insertable = false, updatable = false)
    private LocalDateTime modifiedDatetime;

}
