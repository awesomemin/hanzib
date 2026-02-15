package com.hanzib.api.parent.controller.dto.response;

import com.hanzib.api.parent.Parent;
import com.hanzib.api.parent.ParentRole;

public record CreateParentResponse(
        Long id,
        String email,
        String nickname,
        ParentRole role
) {
    public static CreateParentResponse from(Parent parent) {
        return new CreateParentResponse(
                parent.getId(),
                parent.getEmail(),
                parent.getNickname(),
                parent.getRole()
        );
    }
}