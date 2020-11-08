package com.bee.shop.shipping;

import com.bee.shop.product.ByWeightProduct;
import com.bee.shop.product.CompoundProduct;
import com.bee.shop.product.StandardProduct;
import java.math.BigDecimal;

public enum DomesticShippingFeeVisitor implements ShippingFeeVisitor {
    INSTANCE;

    @Override
    public BigDecimal visit(StandardProduct standardProduct) {
        return BigDecimal.valueOf(15);
    }

    @Override
    public BigDecimal visit(ByWeightProduct byWeightProduct) {
        return byWeightProduct.getWeight().multiply(BigDecimal.valueOf(5));
    }

    @Override
    public BigDecimal visit(CompoundProduct compoundProduct) {
        return compoundProduct.getProducts()
                .stream()
                .map(p -> p.getShippingCost(this))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(BigDecimal.valueOf(0.75));
    }
}
