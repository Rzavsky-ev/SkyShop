package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new HashMap<>();
        addProduct();
        this.articleStorage = new HashMap<>();
        addArticle();
    }


    private void addProduct() {
        Product apple = new SimpleProduct("Б", 10, UUID.randomUUID());
        Product pear = new SimpleProduct("Л", 100, UUID.randomUUID());
        Product banana = new DiscountedProduct("А", 30, 10, UUID.randomUUID());
        Product plum = new FixPriceProduct("Д", UUID.randomUUID());
        productStorage.put(apple.getId(), apple);
        productStorage.put(pear.getId(), pear);
        productStorage.put(banana.getId(), banana);
        productStorage.put(plum.getId(), plum);
    }

    private void addArticle() {
        Article article = new Article(UUID.randomUUID());
        articleStorage.put(article.getId(), article);
    }

    public Collection<Product> getProductStorage() {
        return new ArrayList<>(productStorage.values());
    }

    public Collection<Article> getArticleStorage() {
        return new ArrayList<>(articleStorage.values());
    }

    public Collection<Searchable> getAllSearchable() {
        List<Searchable> allSearchable = new ArrayList<>();
        allSearchable.addAll(getProductStorage());
        allSearchable.addAll(getArticleStorage());
        return allSearchable;
    }
}
