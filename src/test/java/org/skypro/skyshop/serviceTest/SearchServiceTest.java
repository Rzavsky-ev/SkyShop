package org.skypro.skyshop.serviceTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private StorageService testStorageService;

    @InjectMocks
    private SearchService testSearchService;

    @Test
    void testSearch_Empty() {
        when(testStorageService.getAllSearchable()).thenReturn(emptyList());
        Collection<SearchResult> result = testSearchService.search("Яблоко");
        assertEquals(result, Collections.<SearchResult>emptyList());
    }

    @Test
    void testSearch_NotEmpty() {
        Collection<Searchable> collection =
                new ArrayList<>(List.of(new SimpleProduct("Яблоко", 10, UUID.randomUUID())));
        when(testStorageService.getAllSearchable()).thenReturn(collection);
        Collection<SearchResult> result = testSearchService.search("Яб");
        assertEquals(result, Collections.<SearchResult>emptyList());
    }

    @Test
    void testSearch_PresentObject() {
        Collection<Searchable> collection =
                new ArrayList<>(List.of(new SimpleProduct("Яблоко",
                        10, UUID.randomUUID())));
        when(testStorageService.getAllSearchable()).thenReturn(collection);

        List<SearchResult> expectedResults = testStorageService.getAllSearchable().stream().
                filter(searchable -> searchable.getSearchTerm().equals("Яблоко")).
                map(SearchResult::fromSearchable).toList();

        List<SearchResult> result = new ArrayList<>(List.of(SearchResult.fromSearchable
                (new SimpleProduct("Яблоко", 10, UUID.randomUUID()))));

        assertEquals(result.get(0), expectedResults.get(0));
    }

}

