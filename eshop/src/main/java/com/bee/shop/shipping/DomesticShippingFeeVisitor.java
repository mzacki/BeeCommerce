package com.bee.shop.shipping;

import com.bee.shop.product.ByWeightProduct;
import com.bee.shop.product.CompositeProduct;
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
    public BigDecimal visit(CompositeProduct compositeProduct) {
        return compositeProduct.getProducts()
                .stream()
                .map(p -> p.getShippingCost(this))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(BigDecimal.valueOf(0.75));
    }
}
