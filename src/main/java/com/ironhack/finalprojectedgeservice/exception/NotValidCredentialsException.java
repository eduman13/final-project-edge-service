package com.ironhack.finalprojectedgeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotValidCredentialsException extends RuntimeException {

    public NotValidCredentialsException() {
        super("The user/password provided are not valid");
    }
}
