package com.bee.shop.shipping;

import com.bee.shop.product.ByWeightProduct;
import com.bee.shop.product.CompositeProduct;
import com.bee.shop.product.StandardProduct;
import java.math.BigDecimal;


public interface ShippingFeeVisitor {

    BigDecimal visit(StandardProduct standardProduct);

    BigDecimal visit(ByWeightProduct byWeightProduct);

    BigDecimal visit(CompositeProduct compositeProduct);

}
