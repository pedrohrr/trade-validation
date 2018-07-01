package com.pedrohrr.tradevalidation.controller;

import com.pedrohrr.tradevalidation.data.TransactionData;
import com.pedrohrr.tradevalidation.exception.MultipleTransactionException;
import com.pedrohrr.tradevalidation.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private ValidationService service;

    @PostMapping
    public <T extends TransactionData> void validate(@RequestBody final List<T> transactions) throws MultipleTransactionException {
        service.validate(transactions);
    }

}