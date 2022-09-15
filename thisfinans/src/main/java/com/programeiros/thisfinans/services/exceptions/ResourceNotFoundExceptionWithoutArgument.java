package com.programeiros.thisfinans.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundExceptionWithoutArgument extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundExceptionWithoutArgument() {
        super("Resource not found!");
    }
}
