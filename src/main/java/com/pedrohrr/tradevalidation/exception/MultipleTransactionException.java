package com.pedrohrr.tradevalidation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MultipleTransactionException extends Exception {

    private final List<TransactionException> transactionExceptions;

    public MultipleTransactionException(final List<TransactionException> transactionExceptions) {
        this.transactionExceptions = transactionExceptions;
    }

}