package com.bee.shop.payment;

import java.math.BigDecimal;

public class Paypal extends Payment {

    public Paypal() {
    }

    public Paypal(BigDecimal amount) {
        super(amount);
    }

    @Override
    public void accept(PaymentVisitor paymentVisitor) {
        paymentVisitor.visit(this);
    }

}
