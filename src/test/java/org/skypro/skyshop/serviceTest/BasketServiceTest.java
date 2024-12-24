package org.skypro.skyshop.serviceTest;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.service.BasketService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    private BasketService testBasketService;

    @Mock
    private ProductBasket testProductBasket;

    @Test
    public void testAddServiceProduct() {
        UUID id = null;
        assertThrows(NullPointerException.class, () -> {
            testBasketService.addServiceProduct(id);
        });
    }

    @Test
    public void testAddProductBasket() {
        Iterator<UUID> iter = testProductBasket.getProductsBasket().keySet().iterator();
        verify(testProductBasket).addProductBasket(iter.next());
    }

    @Test
    public void testGetUserBasket_Null() {
        when(testProductBasket.getProductsBasket()).thenReturn(null);
    }

    @Test
    public void testGetUserBasket_NotNull() {
        when(testProductBasket.getProductsBasket()).thenReturn(new HashMap<>());
    }
}

