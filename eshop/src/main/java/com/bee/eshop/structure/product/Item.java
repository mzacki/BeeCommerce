package com.bee.eshop.structure.product;

import com.bee.eshop.structure.shipping.ShippingFeeVisitor;
import java.math.BigDecimal;

public interface Item {

    String getName();

    BigDecimal getPrice();

    BigDecimal getWeight();

    BigDecimal getShippingCost(ShippingFeeVisitor shippingFeeVisitor);
}
