package org.skypro.skyshop.model.basket;

import java.util.ArrayList;
import java.util.List;

public class UserBasket {

    private List<BasketItem> basketItems = new ArrayList<>();
    private int total;

    public UserBasket(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public int getTotal() {
        return basketItems.stream().mapToInt
                (item -> item.getProduct().getPriceProduct() * item.getProductQuantity()).sum();
    }
}
