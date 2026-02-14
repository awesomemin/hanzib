package com.hanzib.api.parent.dto.response;

import com.hanzib.api.parent.Parent;

public record CreateParentResponse(
        Long id,
        String email
) {
    public static CreateParentResponse from(Parent parent) {
        return new CreateParentResponse(parent.getId(), parent.getEmail());
    }
}