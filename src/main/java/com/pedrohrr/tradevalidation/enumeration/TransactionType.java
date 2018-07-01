package com.pedrohrr.tradevalidation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TransactionType {
    SPOT, FORWARD, VANILLAOPTION;

    @JsonCreator
    public static TransactionType fromString(final String value) {
        return TransactionType.valueOf(value.toUpperCase());
    }
}
