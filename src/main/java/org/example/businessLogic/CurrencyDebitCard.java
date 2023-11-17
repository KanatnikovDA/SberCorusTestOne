package org.example.businessLogic;

import lombok.NonNull;
import org.example.enums.Currency;

public class CurrencyDebitCard extends DebitCard {
    public CurrencyDebitCard(@NonNull String title) {
        super(title);
        super.setCurrency(Currency.USD);
    }
}
