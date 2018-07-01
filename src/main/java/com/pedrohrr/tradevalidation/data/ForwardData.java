package com.pedrohrr.tradevalidation.data;

import com.pedrohrr.tradevalidation.enumeration.TransactionType;

public class ForwardData extends TransactionData {
    @Override
    public TransactionType getType() {
        return TransactionType.FORWARD;
    }
}
