package org.example.collection;

import java.util.Arrays;

public class CollectionFilter {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};

        Filter filter = new Filter() {
            @Override
            public Object apply(Object o) {
                return o + "s";
            }
        };

        Object[] filteredNumbers = filter(numbers, filter);
        System.out.println(Arrays.toString(filteredNumbers));

    }

    public static Object[] filter(Object[] array, Filter filter) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = filter.apply(array[i]);
        }
        return result;
    }
}

interface Filter {
    Object apply(Object o);
}
