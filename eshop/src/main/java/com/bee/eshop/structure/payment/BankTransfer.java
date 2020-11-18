package com.bee.eshop.structure.payment;

import java.math.BigDecimal;

public class BankTransfer extends Payment {

    public BankTransfer() {}

    public BankTransfer(BigDecimal amount) {
        super(amount);
    }

    @Override
    public void accept(PaymentVisitor paymentVisitor) {
        paymentVisitor.visit(this);
    }

}
