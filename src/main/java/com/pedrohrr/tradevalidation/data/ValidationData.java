package com.pedrohrr.tradevalidation.data;

import lombok.Getter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ValidationData {

    @Getter
    private List<String> validationMessages;

    public ValidationData() {
        validationMessages = new ArrayList<>();
    }

    public void addMessage(final String message) {
        validationMessages.add(message);
    }

    public boolean isValid() {
        return CollectionUtils.isEmpty(validationMessages);
    }
}
