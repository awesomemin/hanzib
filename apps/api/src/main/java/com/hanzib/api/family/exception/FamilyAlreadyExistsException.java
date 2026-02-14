package com.hanzib.api.family.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FamilyAlreadyExistsException extends RuntimeException {

    public FamilyAlreadyExistsException(Long createdBy) {
        super("family already exists for createdBy. id=" + createdBy);
    }
}
