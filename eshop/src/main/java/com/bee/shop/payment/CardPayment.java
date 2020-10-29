package com.bee.shop.payment;

import java.math.BigDecimal;

public class CardPayment extends Payment {

    public CardPayment() {}

    public CardPayment(BigDecimal amount) {
        super(amount);
    }

    @Override
    public void accept(PaymentVisitor paymentVisitor) {
        paymentVisitor.visit(this);
    }

}
