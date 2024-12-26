package org.skypro.skyshop.model.search;


import java.util.UUID;

public final class SearchResult {

    private final UUID id;
    private final String name;
    private final String contentType;

    public SearchResult(UUID id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(searchable.getId(),
                searchable.getSearchTerm(), searchable.getContentType());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SearchResult)) {
            return false;
        }
        SearchResult other = (SearchResult) obj;
        if (!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
}
