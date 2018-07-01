package com.pedrohrr.tradevalidation.validation;

import com.pedrohrr.tradevalidation.data.OptionsData;
import com.pedrohrr.tradevalidation.data.TransactionData;
import com.pedrohrr.tradevalidation.data.ValidationData;

import java.time.DayOfWeek;
import java.util.Currency;
import java.util.Objects;

public final class Validations {

    private static final String PLUTO1 = "PLUTO1";
    private static final String PLUTO2 = "PLUTO2";

    public static void requireNonNull(final ValidationData data, final Object o, final String message) {
        if (o == null) {
            data.addMessage(message);
        }
    }

    public static void valueAndTradeDate(final TransactionData data) {
        try {
            Objects.requireNonNull(data.getValueDate(), "Value Date cannot be null");
            Objects.requireNonNull(data.getTradeDate(), "Trade Date cannot be null");
            if (data.getValueDate().isBefore(data.getTradeDate())) {
                data.addMessage("Value Date cannot be before Trade Date");
            }

            if (DayOfWeek.SATURDAY.equals(data.getValueDate().getDayOfWeek()) || DayOfWeek.SUNDAY.equals(data.getValueDate().getDayOfWeek())) {
                data.addMessage("Value date cannot fall on weekend or non-working day for currency");
            }
        } catch (NullPointerException e) {
            data.addMessage(e.getMessage());
        }
    }

    public static void customer(final TransactionData data) {
        try {
            Objects.requireNonNull(data.getCustomer(), "Customer cannot be null");

            if (!PLUTO1.equalsIgnoreCase(data.getCustomer()) && !PLUTO2.equalsIgnoreCase(data.getCustomer())) {
                data.addMessage("Customer is not permitted");
            }
        } catch (NullPointerException e) {
            data.addMessage(e.getMessage());
        }
    }

    public static void currencies(final TransactionData data) {
        try {
            Objects.requireNonNull(data.getCcyPair(), "Currency Pair cannot be null");

            if (data.getCcyPair().length() != 6) {
                data.addMessage("Currency pair in wrong format");
            } else {
                final String ccyFrom = data.getCcyPair().substring(0, 2);
                final String ccyTo = data.getCcyPair().substring(3, 5);

                if (!validCurrency(ccyFrom)) {
                    data.addMessage("Currency Pair (from) is not a valid currency");
                }

                if (!validCurrency(ccyTo)) {
                    data.addMessage("Currency Pair (to) is not a valid currency");
                }
            }
        } catch (NullPointerException e) {
            data.addMessage(e.getMessage());
        }
    }

    public static void currencies(final OptionsData data) {
        try {
            Objects.requireNonNull(data.getPayCcy(), "Pay Currency cannot be null");
            Objects.requireNonNull(data.getPremiumCcy(), "Premium Currency cannot be null");

            if (!validCurrency(data.getPayCcy())) {
                data.addMessage("Pay Currency is not a valid currency");
            }

            if (!validCurrency(data.getPremiumCcy())) {
                data.addMessage("Premium Currency is not a valid currency");
            }
        } catch (NullPointerException e) {
            data.addMessage(e.getMessage());
        }
    }

    private static boolean validCurrency(final String currency) {
        return Currency.getAvailableCurrencies().stream().anyMatch(c -> c.getCurrencyCode().equals(currency));
    }
}
