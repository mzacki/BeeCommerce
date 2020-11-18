package com.bee.eshop.structure.shipping;

public enum ShippingFeeVisitorFactory {
    INSTANCE;

    public ShippingFeeVisitor get(ShippingOption type) {
        switch (type) {
            case WDT:
                return WdtShippingFeeVisitor.INSTANCE;
            case DOMESTIC:
                return DomesticShippingFeeVisitor.INSTANCE;
            case EXPORT:
                return ExportShippingFeeVisitor.INSTANCE;
            default:
                throw new IllegalArgumentException("Non existing shipping fee type");
        }
    }

}
