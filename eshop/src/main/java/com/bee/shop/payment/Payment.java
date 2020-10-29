package com.bee.shop.payment;

import java.math.BigDecimal;

public abstract class Payment {

    private BigDecimal amount;
    private boolean allowed;

    public Payment() {
        amount = BigDecimal.ZERO;
    }

    public Payment(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public abstract void accept(PaymentVisitor paymentVisitor);

}
