package com.jpa.study.starbucks.jpastudy2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

/**
 * Hibernate 모든 @Entity 스캔하여
 * "엔티티 이름과 매핑된 테이블"을 1:1관계로 등록하기 때문에
 * com.jpa.study.starbucks.jpastudy2 경로에 있는
 * User → User2로 하여
 * org.hibernate.DuplicateMappingException 발생을 피하도록 한다.
 */
@Entity(name = "user2") // DB테이블과 매핑 대상
@Table(name = "user")   // user 테이블과 매핑
public class User {
    @Id     // 식별자에 대응
    private String email;   // email 컬럼과 매핑
    private String name;    // name 컬럼과 매핑
    @Column(name = "create_date")   // create_date 컬럼과 매핑
    private LocalDateTime createDate;

    protected User() {
    }

    public User(String email, String name, LocalDateTime createDate) {
        this.email = email;
        this.name = name;
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                "}";
    }

}
