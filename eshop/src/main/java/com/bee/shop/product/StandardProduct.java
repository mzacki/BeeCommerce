package com.bee.shop.product;

import com.bee.shop.shipping.ShippingFeeVisitor;
import java.math.BigDecimal;

public class StandardProduct implements Item {

    private final String name;
    private final BigDecimal price;
    private final BigDecimal weight;

    public StandardProduct(String name, BigDecimal price, BigDecimal weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public BigDecimal getWeight() {
        return weight;
    }

    @Override
    public BigDecimal getShippingCost(ShippingFeeVisitor shippingFeeVisitor) {
        return shippingFeeVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "Product: " + name +
                ", weight: " + weight +
                ", price: " + price;
    }

}
