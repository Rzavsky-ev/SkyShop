package org.skypro.skyshop.serviceTest;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    private ProductBasket testProductBasket;

    @Mock
    private StorageService testStorageService;

    @InjectMocks
    private BasketService testBasketService;

    @Test
    public void testAddServiceProduct() {
        UUID id = null;
        assertThrows(NoSuchProductException.class, () -> {
            testBasketService.addServiceProduct(id);
        });
    }

    @Test
    public void testAddProductBasket() {
        UUID id = UUID.randomUUID();
        testProductBasket.addProductBasket(id);
        verify(testProductBasket).addProductBasket(id);
    }

    @Test
    public void testGetUserBasket_Null() {
        when(testStorageService.getProductStorage()).thenReturn(emptyList());
        when(testProductBasket.getProductsBasket()).thenReturn(emptyMap());

        UserBasket result = testBasketService.getUserBasket();
        assertEquals(result.getTotal(), 0);
    }

    @Test
    public void testGetUserBasket_NotNull() {
        UUID id = UUID.randomUUID();
        Collection<Product> collection = new ArrayList<>
                (List.of(new SimpleProduct("Яблоко", 10, id)));
        Map<UUID, Integer> map = new HashMap<>(Map.of(id, 1));

        when(testStorageService.getProductStorage()).thenReturn(collection);
        when(testProductBasket.getProductsBasket()).thenReturn(map);

        UserBasket result = testBasketService.getUserBasket();
        assertEquals(result.getTotal(), collection.stream().mapToInt
                (Product::getPriceProduct).sum());

    }
}
