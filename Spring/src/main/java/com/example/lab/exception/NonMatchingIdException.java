package com.example.lab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NonMatchingIdException extends RuntimeException {
    public NonMatchingIdException(final UUID pathId, final UUID entityId) {
        super("Entity and path IDs are not equal. (path ID - " + pathId + ", entity ID - " + entityId + ")!");
    }
}
