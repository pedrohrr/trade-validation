package com.pedrohrr.tradevalidation.validation;

import com.pedrohrr.tradevalidation.data.TransactionData;
import com.pedrohrr.tradevalidation.data.ValidationData;
import org.junit.Assert;
import org.junit.Test;

public class ValidationsTest {

    @Test
    public void requireNonNull() {
        final ValidationData data = new ValidationData();
        Validations.requireNonNull(data, null, "Cannot be null");
        Assert.assertEquals("Cannot be null", data.getValidationMessages().get(0));
    }

    @Test
    public void requireNonEmpty() {
        final ValidationData data = new ValidationData();
        Validations.requireNonNull(data, "NotNull", "Cannot be null");
        Assert.assertTrue(data.getValidationMessages().isEmpty());
    }

    @Test
    public void valueAndTradeDate() {
        final TransactionData data = new TransactionData();
        Validations.valueAndTradeDate(data);
        Assert.assertFalse(data.getValidationMessages().isEmpty());
    }
}