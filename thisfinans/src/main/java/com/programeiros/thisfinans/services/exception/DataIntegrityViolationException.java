package com.programeiros.thisfinans.services.exception;

import java.io.Serial;

public class DataIntegrityViolationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -5861652532984751204L;

    public DataIntegrityViolationException(String message) {
        super(message);
    }

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
