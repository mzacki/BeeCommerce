package com.bee.shop.payment;

public class PaymentFactory {

    public Payment get(PaymentMethod type) {

        switch (type) {
            case CRYPTO_CURRENCY:
                return new CryptoCurrency();
            case BANK_TRANSFER:
                return new BankTransfer();
            case CARD:
                return new CardPayment();
            case PAYPAL:
                return new Paypal();
            default:
                throw new IllegalArgumentException("Illegal payment method");
        }
    }

}
