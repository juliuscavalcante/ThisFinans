package com.programeiros.thisfinans.exceptions.business;

import com.programeiros.thisfinans.exceptions.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountNameRuleException extends BaseRuntimeException {

    private static final String KEY = "account.name.rule";

    public AccountNameRuleException() {
        super();
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}
