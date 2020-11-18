package com.bee.eshop.structure.shipping;

import com.bee.eshop.structure.product.ByWeightProduct;
import com.bee.eshop.structure.product.CompoundProduct;
import com.bee.eshop.structure.product.StandardProduct;
import java.math.BigDecimal;


public interface ShippingFeeVisitor {

    BigDecimal visit(StandardProduct standardProduct);

    BigDecimal visit(ByWeightProduct byWeightProduct);

    BigDecimal visit(CompoundProduct compoundProduct);

}
