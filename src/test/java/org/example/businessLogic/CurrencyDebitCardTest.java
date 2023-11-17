package org.example.businessLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyDebitCardTest {
    private CurrencyDebitCard currencyDebitCard;
    @BeforeEach
    void arrangeTestData() {
        currencyDebitCard = new CurrencyDebitCard("My USD debit Card");
    }

    @Test
    public void testCheckBalanceAndRefillPositive() {
        currencyDebitCard.refill(new BigDecimal(100));

        assertEquals(new BigDecimal(100), currencyDebitCard.checkBalance());
    }

    @Test
    public void testCheckBalanceAndRefillNegative() {
        currencyDebitCard.refill(new BigDecimal(-50));

        assertEquals(new BigDecimal(0), currencyDebitCard.checkBalance());
    }

    @Test
    public void testWithdrawPositive() {
        currencyDebitCard.refill(new BigDecimal(100));
        currencyDebitCard.withdraw(new BigDecimal(100));

        assertEquals(new BigDecimal(0), currencyDebitCard.checkBalance());
    }

    @Test
    public void testWithdrawNegative() {
        currencyDebitCard.withdraw(new BigDecimal(50));

        assertEquals(new BigDecimal(0), currencyDebitCard.checkBalance());
    }
}
