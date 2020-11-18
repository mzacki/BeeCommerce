package com.bee.eshop.structure.payment;


public class PaymentVisitor {

    public void visit(BankTransfer bankTransfer) {
        System.out.println("Bank transfer amount: " + bankTransfer.getAmount());
    }

    public void visit(Paypal paypal) {
        System.out.println("Paypal transfer:" + paypal.getAmount());
    }

    public void visit(CardPayment cardPayment) {
        System.out.println("Card payment: " + cardPayment.getAmount());
    }

    public void visit(CryptoCurrency cryptoCurrency) {
        System.out.println("Crypto currency payment " + cryptoCurrency.getAmount());
    }

}
