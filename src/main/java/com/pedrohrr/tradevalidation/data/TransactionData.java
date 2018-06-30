package com.pedrohrr.tradevalidation.data;

import com.pedrohrr.tradevalidation.enumeration.TransactionDirection;
import com.pedrohrr.tradevalidation.enumeration.TransactionType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionData {

    private TransactionType type;
    private String customer;
    private String  ccyPair;
    private TransactionDirection direction;
    private LocalDate tradeDate;
    private Double amount1;
    private Double amount2;
    private Double rate;
    private LocalDate valueDate;
    private String legalEntity;
    private String trader;

}