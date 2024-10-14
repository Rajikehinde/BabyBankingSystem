package com.babyBankingSystem.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    //resourceName(Account or Customer) fieldName( mobileNumber or parameter) fieldValue
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with the given input %s ", resourceName,fieldName, fieldValue));
    }
}
