package com.hanzib.api.family.dto.response;

import com.hanzib.api.family.Family;

public record CreateFamilyResponse(
        Long id,
        Long createdBy
) {
    public static CreateFamilyResponse from(Family family) {
        return new CreateFamilyResponse(family.getId(), family.getCreatedBy().getId());
    }
}