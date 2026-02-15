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

    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private ParentRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAMILY_ID")
    private Family family;

    private Parent(String email, String nickname, ParentRole role) {
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }

    public static Parent of(String email, String nickname, ParentRole role) {
        return new Parent(email, nickname, role);
    }

    public void joinFamily(Family family) {
        this.family = family;
    }

}