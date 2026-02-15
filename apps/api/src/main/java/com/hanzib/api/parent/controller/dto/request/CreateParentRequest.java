package com.hanzib.api.parent.controller.dto.request;

import com.hanzib.api.parent.ParentRole;
import jakarta.validation.constraints.NotNull;

public record CreateParentRequest(
        @NotNull
        String email,
        @NotNull
        String nickname,
        ParentRole role
) {
}