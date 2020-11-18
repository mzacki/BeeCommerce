package com.bee.eshop.structure.payment;

import java.math.BigDecimal;

public class CryptoCurrency extends Payment {

    public CryptoCurrency() {
    }

    public CryptoCurrency(BigDecimal amount) {
        super(amount);
    }

    @Override
    public void accept(PaymentVisitor paymentVisitor) {
        paymentVisitor.visit(this);
    }

}
