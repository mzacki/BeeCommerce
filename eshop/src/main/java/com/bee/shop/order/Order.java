package com.bee.shop.order;

import com.bee.shop.payment.PaymentMethod;
import com.bee.shop.payment.PaymentVisitor;
import com.bee.shop.product.Item;
import com.bee.shop.shipping.ShippingOption;
import java.math.BigDecimal;

public interface Order {

    void addItem(Item item);

    void removeItem(Item item);

    void setDiscountOnItem(Item item, BigDecimal discount);

    void setShippingOption(ShippingOption shippingOption);

    void setPaymentMethod(PaymentMethod paymentMethod);

    void makePayment(PaymentVisitor paymentVisitor);

}
