package org.example.businessLogic;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.example.intefaces.CreditCardOperations;
import org.example.intefaces.WithdrawOperation;

import java.math.BigDecimal;

@Getter
@Setter
public class CreditCard extends BankProduct implements CreditCardOperations, WithdrawOperation {
    private BigDecimal interestRate = BigDecimal.ZERO;

    public CreditCard(@NonNull String title) {
        super(title);
    }

    /**
     * Пополнение баланса Кредитная карта
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
     * Снятие средств с Кредитной карты
     *
     * @param amount сумма снятия
     */
    @Override
    public BigDecimal withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            return BigDecimal.ZERO;

        setBalance(getBalance().subtract(amount));
        return amount;
    }

    /**
     * Проверка баланса Кредитная карта
     *
     * @return баланс Кредитная карта
     */
    @Override
    public BigDecimal checkBalance() {
        return getBalance();
    }

    /**
     * Проверяем задолженность по Кредитной карте
     *
     * @return сумма задолженности
     */
    @Override
    public BigDecimal checkDebt() {
        if (getBalance().compareTo(BigDecimal.ZERO) >= 0) {
            return BigDecimal.ZERO;
        } else {
            return getBalance();
        }
    }
}
