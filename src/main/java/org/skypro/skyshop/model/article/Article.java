package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public class Article implements Searchable {

    private String articleTitle = "Статья";
    private String textOfArticle = "Текст";

    private final UUID id;

    public Article(UUID id) {
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Название статьи: " + articleTitle + " Текст статьи " + textOfArticle;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return this.toString();
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object obj) {
        // Проверка на null
        if (obj == null) {
            return false;
        }
        // Проверка на тип
        if (!(obj instanceof Article)) {
            return false;
        }
        // Приведение к типу Person
        Article other = (Article) obj;
        return this.articleTitle.equals(other.articleTitle);
    }

    @Override
    public int hashCode() {
        if (articleTitle == null) {
            return 0;
        }
        return articleTitle.hashCode();
    }
}
