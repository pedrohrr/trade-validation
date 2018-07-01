package com.pedrohrr.tradevalidation.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.pedrohrr.tradevalidation.enumeration.TransactionDirection;
import com.pedrohrr.tradevalidation.enumeration.TransactionType;
import com.pedrohrr.tradevalidation.validation.Validations;
import lombok.Data;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = SpotData.class, name = "Spot"),
    @JsonSubTypes.Type(value = ForwardData.class, name = "Forward"),
    @JsonSubTypes.Type(value = OptionsData.class, name = "VanillaOption")
})
public abstract class TransactionData extends ValidationData {

    private String customer;
    private String ccyPair;
    private TransactionDirection direction;
    private LocalDate tradeDate;
    private Double amount1;
    private Double amount2;
    private Double rate;
    private LocalDate valueDate;
    private String legalEntity;
    private String trader;
    private String style;

    public abstract TransactionType getType();

    public boolean validate() {
        Validations.valueAndTradeDate(this);
        Validations.customer(this);
        Validations.currencies(this);

        return isValid();
    }

}