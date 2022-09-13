package com.programeiros.thisfinans.exceptions.business;

import com.programeiros.thisfinans.exceptions.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountNameRuleWithParamsException extends BaseRuntimeException {

    private static final String KEY = "account.name.rule.with.params";

    public AccountNameRuleWithParamsException(String value) {
        super(Map.of("value", value));
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}

