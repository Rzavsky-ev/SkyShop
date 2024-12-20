package org.skypro.skyshop.service;


import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final ProductBasket productBasket;
    private final StorageService storageService;


    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;

    }

    public void addServiceProduct(UUID id) {
        storageService.getProductById(id).ifPresentOrElse(product -> productBasket.addProductBasket(product.getId()),
                () -> {
                    throw new IllegalArgumentException();
                });
    }

    public UserBasket getUserBasket() {
        Map<UUID, Product> productMap = storageService.getProductStorage().stream().
                collect(Collectors.toMap(Product::getId, p -> p));

        return new UserBasket(productBasket.getProductsBasket().entrySet().stream().
                filter(entry -> productMap.containsKey(entry.getKey())).
                map(entry -> new BasketItem
                        (productMap.get(entry.getKey()), entry.getValue())).collect(Collectors.toList()));
    }

}

