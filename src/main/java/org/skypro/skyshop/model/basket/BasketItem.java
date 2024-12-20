package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public final class BasketItem {
    private Product product;
    private int productQuantity;

    public BasketItem(Product product, int productQuantity){
        this.product=product;
        this.productQuantity=productQuantity;
    }

    public Product getProduct(){
        return product;
    }

    public int getProductQuantity(){
        return productQuantity;
    }
}
