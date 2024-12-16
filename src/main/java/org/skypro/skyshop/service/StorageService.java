package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StorageService {
    Product apple = new SimpleProduct("Б", 10, UUID.randomUUID());
    Product pear = new SimpleProduct("Л", 100, UUID.randomUUID());
    Product banana = new DiscountedProduct("А", 30, 10, UUID.randomUUID());
    Product plum = new FixPriceProduct("Д", UUID.randomUUID());
    Article article = new Article(UUID.randomUUID());

    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new HashMap<>();
        addProduct(apple);
        addProduct(pear);
        addProduct(banana);
        addProduct(plum);

        this.articleStorage = new HashMap<>();
        addArticle(article);
    }

    private void addProduct(Product product) {
        productStorage.put(product.getId(), product);
    }

    private void addArticle(Article article) {
        articleStorage.put(article.getId(), article);
    }

    public Stream<Product> getProductStorage() {
        return productStorage.values().stream();
    }

    public Stream<Article> getArticleStorage() {
        return articleStorage.values().stream();
    }

    public Collection<Searchable> getAllSearchable() {
        List<Searchable> allSearchable = new ArrayList<>();
        allSearchable.addAll(getProductStorage().toList());
        allSearchable.addAll(getArticleStorage().toList());
        return allSearchable;
    }
}
