package com.programeiros.thisfinans.exceptions;

import com.programeiros.thisfinans.exceptions.contract.MessageException;

import java.util.Map;

public abstract class BaseRuntimeException extends RuntimeException implements MessageException {

    private final Map<String, Object> mapDetails;

    public BaseRuntimeException() {
        mapDetails = null;
    }

    public BaseRuntimeException(final Map<String, Object> mapDetails) {
        this.mapDetails = mapDetails;
    }

    public abstract String getExceptionKey();public Map<String, Object> getMapDetails() {
        return this.mapDetails;
    }
}
