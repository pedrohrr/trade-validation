package com.pedrohrr.tradevalidation.data;

import com.pedrohrr.tradevalidation.enumeration.TransactionType;

public class SpotData extends TransactionData {
    @Override
    public TransactionType getType() {
        return TransactionType.SPOT;
    }
}