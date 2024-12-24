package org.skypro.skyshop.serviceTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.service.StorageService;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StorageServiceTest {

    @Mock
    private StorageService testStorageService;

    @Test
    void testGetArticleStorage_Null() {
        when(testStorageService.getArticleStorage()).thenReturn(null);
    }

    @Test
    void testGetProductStorage_NotNull() {
        when(testStorageService.getProductStorage()).thenReturn(null);
    }

}

