package org.example.businessLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebitCardTest {
    private DebitCard debitCard;
    @BeforeEach
    void arrangeTestData() {
        debitCard = new DebitCard("My debit card");
    }

    @Test
    public void testCheckBalanceAndRefillPositive() {
        debitCard.refill(new BigDecimal(100));
        assertEquals(new BigDecimal(100), debitCard.checkBalance());
    }

    @Test
    public void testCheckBalanceAndRefillNegative() {
        debitCard.refill(new BigDecimal(-50));
        assertEquals(new BigDecimal(0), debitCard.checkBalance());
    }

    @Test
    public void testWithdrawPositive() {
        debitCard.refill(new BigDecimal(100));
        debitCard.withdraw(new BigDecimal(100));
        assertEquals(new BigDecimal(0), debitCard.checkBalance());
    }

    @Test
    public void testWithdrawNegative() {
        debitCard.withdraw(new BigDecimal(50));
        assertEquals(new BigDecimal(0), debitCard.checkBalance());
    }
}
