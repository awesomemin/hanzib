package com.hanzib.api.family.controller.dto.response;

import com.hanzib.api.family.Family;

import java.util.List;

public record ReadFamilyResponse(
        Long id,
        Long createdBy,
        List<Long> parents,
        List<Long> children
) {

    public static ReadFamilyResponse from(Family family) {
        Long createdById = family.getCreatedBy().getId();
        return new ReadFamilyResponse(
                family.getId(),
                createdById,
                List.of(createdById),
                List.of()
        );
    }
}