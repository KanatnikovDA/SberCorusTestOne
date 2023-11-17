package org.example.businessLogic;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.example.enums.Currency;
import org.example.enums.Status;
import org.example.intefaces.MainOperation;

import java.math.BigDecimal;

@Getter
@Setter
abstract class BankProduct implements MainOperation {

    protected Currency currency;
    protected BigDecimal balance;
    protected String title;
    protected Status status;

    public BankProduct(@NonNull String title) {
        this.currency = Currency.RUR;
        this.balance = BigDecimal.ZERO;
        this.title = title;
        this.status = Status.OPEN;
    }
}