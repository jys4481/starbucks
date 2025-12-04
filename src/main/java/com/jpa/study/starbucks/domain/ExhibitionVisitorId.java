package com.jpa.study.starbucks.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExhibitionVisitorId implements Serializable {

    @Column(name = "exhibition_id")
    private Long exhibitionId;
    @Column(name = "visitor_id")
    private String visitorId;

    public ExhibitionVisitorId() {}

    public ExhibitionVisitorId(Long exhibitionId, String visitorId) {
        this.exhibitionId = exhibitionId;
        this.visitorId = visitorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExhibitionVisitorId)) return false;
        ExhibitionVisitorId that = (ExhibitionVisitorId) o;
        return Objects.equals(exhibitionId, that.exhibitionId) &&
                Objects.equals(visitorId, that.visitorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exhibitionId, visitorId);
    }

}
