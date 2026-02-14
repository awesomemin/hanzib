package com.hanzib.api.child;

import com.hanzib.api.common.BaseEntity;
import com.hanzib.api.family.Family;
import jakarta.persistence.*;

@Entity
public class Child extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;

    private Long point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAMILY_ID")
    private Family family;

}