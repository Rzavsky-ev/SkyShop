package org.skypro.skyshop.serviceTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.service.SearchService;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private SearchService testSearchService;

    @Test
    void testSearch_Null() {
        String pattern = "Абв";
        when(testSearchService.search(pattern)).thenReturn(null);
    }

    @Test
    void testSearch_NotNull() {
        String pattern = "Яблоко";
        when(testSearchService.search(pattern)).thenReturn(new ArrayList<>());
    }
}
