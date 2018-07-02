package com.pedrohrr.tradevalidation.data;

import com.pedrohrr.tradevalidation.validation.Validations;

public class SpotData extends TransactionData {

    @Override
    public boolean validate() {
        super.validate();

        Validations.valueAndTradeDate(this);

        return isValid();
    }
}