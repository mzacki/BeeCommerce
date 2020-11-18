package com.bee.eshop.structure.product;

import com.bee.eshop.structure.shipping.ShippingFeeVisitor;
import java.math.BigDecimal;
import java.util.List;

public class CompoundProduct implements Item {

    private final List<Item> items;
    private final String name;

    public CompoundProduct(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public List<Item> getProducts() {
        return items;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal getWeight() {
        return items.stream()
                .map(Item::getWeight)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal getShippingCost(ShippingFeeVisitor shippingFeeVisitor) {
        return shippingFeeVisitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Compound product: ").append(name).append(", content: [");
        items.forEach(p -> stringBuilder.append("\n\t")
                .append(p));
        stringBuilder.append("\n]");
        return stringBuilder.toString();
    }

}
