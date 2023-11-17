package org.example.businessLogic;

import lombok.NonNull;
import org.example.intefaces.WithdrawOperation;

import java.math.BigDecimal;

public class DebitCard extends BankProduct implements WithdrawOperation {
    public DebitCard(@NonNull String title) {
        super(title);
    }

    /**
     * Пополнение баланса Дебетовой Карты
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
     * Снятие средств с Дебетовой Карты
     *
     * @param amount сумма снятия
     */
    @Override
    public BigDecimal withdraw(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            // сумма к снятию отрицательная, возвращаем 0
            return BigDecimal.ZERO;
        }

        if (amount.compareTo(getBalance()) > 0) {
            // сумма превышает баланс, возвращаем 0
            return BigDecimal.ZERO;
        }

        // сумма положительная и не превышает баланс
        setBalance(getBalance().subtract(amount));
        return amount;

    }

    /**
     * Проверка баланса Дебетовой Карты
     *
     * @return баланс Дебетовой Карты
     */
    @Override
    public BigDecimal checkBalance() {
        return getBalance();
    }
}
