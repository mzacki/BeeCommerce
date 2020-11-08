package com.bee.shop.product;

import com.bee.shop.shipping.ShippingFeeVisitor;
import java.math.BigDecimal;

public class ByWeightProduct implements Item {

    private final BigDecimal weight;
    private final BigDecimal price;
    private final String name;

    public ByWeightProduct(String name, BigDecimal weight, BigDecimal price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public BigDecimal getPrice() {
        return weight.multiply(price);
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
                ", price per kg: " + price;
    }

}


