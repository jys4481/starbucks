package com.jpa.study.starbucks.jpastudy3;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity                     // 매핑 대상 엔티티
@Table(name = "hotel_info") // hotel_info 테이블에 매핑
public class Hotel {

    @Id                                 // 식별자로 매핑
    @Column(name = "hotel_id")          // hotel_id 컬럼에 매핑
    private String id;

    @Column(name = "nm")                // nm 컬럼에 매핑
    private String name;

    private int year;                   // year 컬럼에 매핑

    @Enumerated(EnumType.STRING)        // 열거타입 이름을 값으로 저장, grade 컬럼에 매핑
    private Grade grade;

    private LocalDateTime created;      // created 컬럼에 매핑

    @Column(name = "modified")
    private LocalDateTime lastModified; // modified 컬럼에 매핑

    protected Hotel() {
    }

    public Hotel(String id, String name, int year, Grade grade) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.grade = grade;
        this.created = LocalDateTime.now();
        this.lastModified = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Grade getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", grade=" + grade +
                ", created=" + created +
                ", lastModified=" + lastModified +
                '}';
    }

}
