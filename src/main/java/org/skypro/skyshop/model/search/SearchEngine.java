package org.skypro.skyshop.model.search;

import org.skypro.skyshop.model.exceptions.BestResultNotFound;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> setSearchable = new HashSet<>();

    public Set<Searchable> search() {
        Supplier<TreeSet<Searchable>> supplier = () -> new TreeSet<>(new NameComparator());
        return setSearchable.stream().collect(Collectors.toCollection(supplier));
    }

    public void printSearch(Set<Searchable> search) {
        for (Searchable p : search) {
            System.out.println(p.getSearchTerm());
        }
    }


    public void add(Searchable searchable) {
        setSearchable.add(searchable);
    }

    public Searchable searchForMostSuitable(String search) throws BestResultNotFound {
        int counter = 0;
        Searchable result = null;
        for (Searchable searchable : setSearchable) {
            if (countOccurrences(search, searchable.getSearchTerm()) > counter) {
                counter = countOccurrences(searchable.getSearchTerm(), search);
                result = searchable;
            }
        }
        if (result == null) {
            throw new BestResultNotFound("Лучший результат не найден.");
        }
        return result;
    }

    private int countOccurrences(String search, String searchTerm) {
        int index = 0;
        int counter = 0;
        int indexSubstring = searchTerm.indexOf(search, index);
        while (indexSubstring != -1) {
            counter++;
            index += search.length();
            indexSubstring = searchTerm.indexOf(search, index);
        }
        return counter;
    }

    private static class NameComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            if (Integer.compare(o1.getSearchTerm().length(), o2.getSearchTerm().length()) != 0) {
                return Integer.compare(o1.getSearchTerm().length(), o2.getSearchTerm().length());
            }
            return o1.getSearchTerm().compareTo(o2.getSearchTerm());
        }
    }
}
