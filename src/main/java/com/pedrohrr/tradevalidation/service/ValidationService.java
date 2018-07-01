package com.pedrohrr.tradevalidation.service;

import static com.pedrohrr.tradevalidation.ValidationConfiguration.ValidationContext;

import com.pedrohrr.tradevalidation.data.ForwardData;
import com.pedrohrr.tradevalidation.data.OptionsData;
import com.pedrohrr.tradevalidation.data.SpotData;
import com.pedrohrr.tradevalidation.data.TransactionData;
import com.pedrohrr.tradevalidation.exception.MultipleTransactionException;
import com.pedrohrr.tradevalidation.exception.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationService {

    @Autowired
    private ValidationContext validationContext;

    public <T extends TransactionData> void validate(final List<T> transactions) throws MultipleTransactionException {
        final List<TransactionException> exceptions = new ArrayList<>();
        transactions.forEach(t -> {
            try {
                validate(t);
            } catch (final TransactionException e) {
                exceptions.add(e);
            }
        });

        if (!CollectionUtils.isEmpty(exceptions)) {
            throw new MultipleTransactionException(exceptions);
        }
    }

    public void validate(final TransactionData transaction) throws TransactionException {
        validationContext.validateByType(transaction);
    }

}