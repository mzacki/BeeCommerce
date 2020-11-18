package com.bee.eshop.structure.product;

import com.bee.eshop.structure.shipping.ShippingFeeVisitor;
import java.math.BigDecimal;

public class DiscountedProduct implements Item {

    private final Item item;
    private final BigDecimal discount;

    public DiscountedProduct(Item item, BigDecimal discount) {
        this.item = item;
        this.discount = discount;
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public BigDecimal getPrice() {
        return item.getPrice().subtract(discount);
    }

    @Override
    public BigDecimal getWeight() {
        return item.getWeight();
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    @Override
    public BigDecimal getShippingCost(ShippingFeeVisitor shippingFeeVisitor) {
        return item.getShippingCost(shippingFeeVisitor);
    }

    @Override
    public String toString() {
        return item.toString() + " discount: " + discount;
    }

}
