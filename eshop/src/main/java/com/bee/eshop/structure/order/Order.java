package com.bee.eshop.structure.order;

import com.bee.eshop.structure.payment.PaymentMethod;
import com.bee.eshop.structure.payment.PaymentVisitor;
import com.bee.eshop.structure.product.Item;
import com.bee.eshop.structure.shipping.ShippingOption;
import java.math.BigDecimal;

public interface Order {

    void addItem(Item item);

    void removeItem(Item item);

    void setDiscountOnItem(Item item, BigDecimal discount);

    void setShippingOption(ShippingOption shippingOption);

    void setPaymentMethod(PaymentMethod paymentMethod);

    void makePayment(PaymentVisitor paymentVisitor);

}
