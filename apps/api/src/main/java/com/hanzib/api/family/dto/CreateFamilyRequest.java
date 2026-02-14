package com.hanzib.api.family.dto;

import jakarta.validation.constraints.NotNull;

public record CreateFamilyRequest(
        @NotNull
        Long createdBy
) {
}
