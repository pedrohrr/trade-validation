package com.pedrohrr.tradevalidation;

import com.pedrohrr.tradevalidation.data.TransactionData;
import com.pedrohrr.tradevalidation.exception.TransactionException;
import com.pedrohrr.tradevalidation.strategy.TypeValidationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ValidationConfiguration {

    @Bean
    public ValidationContext getContext() {
        return new ValidationContext();
    }

    public static class ValidationContext {
        private final List<TypeValidationStrategy> strategies;

        protected ValidationContext() {
            strategies = Arrays.asList(
                TypeValidationStrategy.SPOT,
                TypeValidationStrategy.FORWARD,
                TypeValidationStrategy.VANILLAOPTION);
        }

        public void validateByType(final TransactionData transaction) throws TransactionException {
            findTypeStrategy(transaction).validate(transaction);
        }

        private TypeValidationStrategy findTypeStrategy(final TransactionData transaction) {
            return strategies.stream().filter(s -> s.getValidationType().equals(transaction.getType())).findFirst().get();
        }
    }

}