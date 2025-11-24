package com.jpa.study.starbucks.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity                 // DB테이블과 매핑 대상
@Table(name = "user")   // user 테이블과 매핑
public class User {

    @Id     // 식별자에 대응
    private String email;   // email 컬럼과 매핑
    private String name;    // name 컬럼과 매핑
    @Column(name = "create_date")   // create_date 컬럼과 매핑
    private LocalDateTime createDate;

}
