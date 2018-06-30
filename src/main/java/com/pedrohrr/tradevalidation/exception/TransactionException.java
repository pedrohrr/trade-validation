package com.pedrohrr.tradevalidation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TransactionException extends Exception {

    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }

}