package org.example.businessLogic;

import lombok.NonNull;
import org.example.enums.Status;
import org.example.intefaces.DepositOperations;

import java.math.BigDecimal;

public class Deposit extends BankProduct implements DepositOperations {
    public Deposit(@NonNull String title) {
        super(title);
    }

    /**
     * Пополнение баланса Депозита
     *
     * @param amount сумма пополнения
     */
    @Override
    public void refill(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            return;
        setBalance(getBalance().add(amount));
    }

    /**
     * Проверка баланса
     *
     * @return баланс депозита
     */
    @Override
    public BigDecimal checkBalance() {
        return getBalance();
    }

    /**
     * Закрытие депозита
     *
     * @return снятые средства
     */
    @Override
    public BigDecimal close() {
        setStatus(Status.CLOSED);
        return getBalance();
    }
}
