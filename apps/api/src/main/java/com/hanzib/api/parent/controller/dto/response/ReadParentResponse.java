package com.hanzib.api.parent.controller.dto.response;

import com.hanzib.api.family.Family;
import com.hanzib.api.parent.Parent;

public record ReadParentResponse(
        Long id,
        String email,
        Long familyId
) {
    public static ReadParentResponse from(Parent parent) {
        Family family = parent.getFamily();
        if (family == null) {
            return new ReadParentResponse(parent.getId(), parent.getEmail(), null);
        }
        return new ReadParentResponse(parent.getId(), parent.getEmail(), family.getId());
    }
}