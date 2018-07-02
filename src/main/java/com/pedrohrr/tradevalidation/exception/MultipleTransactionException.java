package com.pedrohrr.tradevalidation.exception;

import lombok.Getter;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MultipleTransactionException extends Exception {

    @Getter
    private final List<TransactionException> transactionExceptions;

    public MultipleTransactionException(final List<TransactionException> transactionExceptions) {
        this.transactionExceptions = transactionExceptions;
    }

    @Override
    public String getMessage() {
        final List<String> messages = transactionExceptions.stream().map(TransactionException::getMessage).collect(Collectors.toList());
        return StringUtils.join(messages);
    }
}