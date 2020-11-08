package com.bee.shop.product;

import com.bee.shop.shipping.ShippingFeeVisitor;
import java.math.BigDecimal;

public interface Item {

    String getName();

    BigDecimal getPrice();

    BigDecimal getWeight();

    BigDecimal getShippingCost(ShippingFeeVisitor shippingFeeVisitor);
}
