package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private int priceProduct;

    public SimpleProduct(String nameProduct, int priceProduct, UUID id) {
        super(nameProduct, id);
        if (priceProduct < 1) {
            throw new IllegalArgumentException("Неправильная цена товара");
        }
        this.priceProduct = priceProduct;
    }

    @Override
    public int getPriceProduct() {
        return priceProduct;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "Имя товара:" + getNameProduct() + " стоимость:" + getPriceProduct();
    }
}
