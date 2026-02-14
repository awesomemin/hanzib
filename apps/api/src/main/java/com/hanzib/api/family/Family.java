package com.hanzib.api.family;

import com.hanzib.api.common.BaseEntity;
import com.hanzib.api.parent.Parent;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Family extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "FAMILY_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY", nullable = false)
    private Parent createdBy;

    private Family(Parent createdBy) {
        this.createdBy = createdBy;
    }

    public static Family of(Parent createdBy) {
        return new Family(createdBy);
    }
}