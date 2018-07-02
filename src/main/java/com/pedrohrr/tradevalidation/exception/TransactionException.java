package com.pedrohrr.tradevalidation.exception;

import com.pedrohrr.tradevalidation.data.TransactionData;
import lombok.Getter;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TransactionException extends Exception {

    @Getter
    private TransactionData data;

    public TransactionException(final TransactionData data) {
        this.data = data;
    }

    @Override
    public String getMessage() {
        return String.format("Transaction %s with following errors: %s", data.toString(), StringUtils.join(data.getValidationMessages()));
    }
}