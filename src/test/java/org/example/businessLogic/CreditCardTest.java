package org.example.businessLogic;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CreditCardTest {
    private CreditCard creditCard;

    @BeforeEach
    void arrangeTestData() {
        creditCard = new CreditCard("My Credit Card");
    }

    @Test
    public void testCheckBalanceAndRefillPositive() {
        creditCard.refill(new BigDecimal(100));

        assertEquals(new BigDecimal(100), creditCard.checkBalance());
    }

    @Test
    public void testCheckBalanceAndRefillNegative() {
        creditCard.refill(new BigDecimal(-50));

        assertEquals(new BigDecimal(0), creditCard.checkBalance());
    }

    @Test
    public void testWithdrawPositive() {
        creditCard.withdraw(new BigDecimal(100));

        assertEquals(new BigDecimal(-100), creditCard.checkBalance());
    }

    @Test
    public void testWithdrawNegative() {
        creditCard.withdraw(new BigDecimal(-50));

        assertEquals(new BigDecimal(0), creditCard.checkBalance());
    }

    @Test
    public void testCheckDebtPositive() {
        BigDecimal debt = new BigDecimal(-100);
        creditCard.setBalance(debt);

        assertEquals(debt, creditCard.checkDebt());
    }

    @Test
    public void testCheckDebtNegative() {
        BigDecimal debt = new BigDecimal(-100);
        creditCard.setBalance(debt);

        assertNotEquals(BigDecimal.ZERO, creditCard.checkDebt());
    }
}