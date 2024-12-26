package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class ProductBasket {
    private final Map<UUID, Integer> productsBasket = new HashMap<>();
    private Integer quantityProducts = 1;

    public void addProductBasket(UUID id) {
        if (!productsBasket.containsKey(id)) {
            productsBasket.put(id, quantityProducts);
        } else {
            productsBasket.put(id, productsBasket.get(id) + 1);
        }
    }

    public Map<UUID, Integer> getProductsBasket() {
        return Collections.unmodifiableMap(productsBasket);
    }
}
