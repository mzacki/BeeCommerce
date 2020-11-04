package com.bee.shop.shipping;

public class ShippingFeeVisitorFactory {

    public ShippingFeeVisitor get(ShippingOption type) {
        switch (type) {
            case WDT:
                return WDTShippingFeeVisitor.INSTANCE;
            case DOMESTIC:
                return DomesticShippingFeeVisitor.INSTANCE;
            case EXPORT:
                return ExportShippingFeeVisitor.INSTANCE;
            default:
                throw new IllegalArgumentException("Non existing shipping fee type");
        }
    }

}
