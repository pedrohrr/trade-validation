package com.pedrohrr.tradevalidation.data;

import com.pedrohrr.tradevalidation.enumeration.TransactionType;
import com.pedrohrr.tradevalidation.validation.Validations;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OptionsData extends TransactionData {

    private String strategy;
    private LocalDate deliveryDate;
    private LocalDate expiryDate;
    private String payCcy;
    private Double premium;
    private String premiumCcy;
    private String premiumType;
    private String premiumDate;

    @Override
    public TransactionType getType() {
        return TransactionType.VANILLAOPTION;
    }

    @Override
    public boolean validate() {
        super.validate();

        Validations.currencies(this);

        return isValid();
    }
}
