package com.bee.eshop.structure.order;

import com.bee.eshop.structure.payment.Payment;
import com.bee.eshop.structure.payment.PaymentFactory;
import com.bee.eshop.structure.payment.PaymentMethod;
import com.bee.eshop.structure.payment.PaymentVisitor;
import com.bee.eshop.structure.product.DiscountedProduct;
import com.bee.eshop.structure.product.Item;
import com.bee.eshop.structure.shipping.ShippingFeeVisitor;
import com.bee.eshop.structure.shipping.ShippingFeeVisitorFactory;
import com.bee.eshop.structure.shipping.ShippingOption;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RetailOrder implements Order {

    private List<Item> items;
    private Payment payment;
    private ShippingOption shippingOption;

    public RetailOrder() {
        items = new ArrayList<>();
        payment = new PaymentFactory().get(PaymentMethod.BANK_TRANSFER);
        shippingOption = ShippingOption.DOMESTIC;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
        updatePaymentAmount();
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
        updatePaymentAmount();
    }

    @Override
    public void setDiscountOnItem(Item item, BigDecimal discount) {
        items.remove(item);
        items.add(new DiscountedProduct(item, discount));
        updatePaymentAmount();
    }

    @Override
    public void setShippingOption(ShippingOption shippingOption) {
        this.shippingOption = shippingOption;
    }

    @Override
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        payment = new PaymentFactory().get(paymentMethod);
        updatePaymentAmount();
    }

    private void updatePaymentAmount() {
        ShippingFeeVisitor shippingFeeVisitor = ShippingFeeVisitorFactory.INSTANCE.get(shippingOption);
        BigDecimal totalAmount = items
                .stream()
                .map(p -> p.getPrice().add(p.getShippingCost(shippingFeeVisitor)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        payment.setAmount(totalAmount);
    }

    @Override
    public void makePayment(PaymentVisitor visitor) {
        payment.accept(visitor);
    }

}
