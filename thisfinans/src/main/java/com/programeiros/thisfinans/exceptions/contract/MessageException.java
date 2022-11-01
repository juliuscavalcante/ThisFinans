package com.programeiros.thisfinans.exceptions.contract;

import java.util.Map;

public interface MessageException {

    String getExceptionKey();
    Map<String, Object> getMapDetails();
}
