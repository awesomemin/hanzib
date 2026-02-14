package com.hanzib.api.parent;

import com.hanzib.api.common.BaseEntity;
import com.hanzib.api.family.Family;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Parent extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAMILY_ID")
    private Family family;

    private Parent(String email) {
        this.email = email;
    }

    public static Parent of(String email) {
        return new Parent(email);
    }

}