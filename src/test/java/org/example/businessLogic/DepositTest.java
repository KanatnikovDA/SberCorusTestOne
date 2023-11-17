package org.example.businessLogic;

import org.example.enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DepositTest {
    private Deposit deposit;
    @BeforeEach
    void arrangeTestData() {
        deposit = new Deposit("My Deposit");
    }

    @Test
    public void testCheckBalanceAndRefillPositive() {
        deposit.refill(new BigDecimal(100));
        assertEquals(new BigDecimal(100), deposit.checkBalance());
    }

    @Test
    public void testCheckBalanceAndRefillNegative() {
        deposit.refill(new BigDecimal(-50));
        assertEquals(new BigDecimal(0), deposit.checkBalance());
    }

    @Test
    public void testClosePositive() {
        deposit.refill(new BigDecimal("100"));
        deposit.close();
        assertEquals(Status.CLOSED, deposit.getStatus());
        assertEquals(BigDecimal.ZERO, deposit.checkBalance());
    }

    @Test
    public void testCloseNegative() {
        deposit.close();
        assertNotEquals(Status.OPEN, deposit.getStatus());
    }
}
