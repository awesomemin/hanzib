package com.hanzib.api.family.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CreatedByParentNotFoundException extends RuntimeException {

    public CreatedByParentNotFoundException(Long createdBy) {
        super("createdBy parent not found. id=" + createdBy);
    }
}
