package com.hanzib.api.parent.controller.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateParentRequest(
        @NotNull
        String email
) {
}