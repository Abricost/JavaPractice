package org.example.collection;

import java.util.HashMap;
import java.util.Map;

public class CountOfElements {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 2, 1, 2, 3, 4, 4, 4};
        Map<Object, Integer> frequencyMap = countObjects(numbers);
        System.out.println(frequencyMap);
    }

    public static Map<Object, Integer> countObjects(Object[] array) {
        Map<Object, Integer> frequencyMap = new HashMap<>();
        for (Object element : array) {
            if (frequencyMap.containsKey(element)) {
                frequencyMap.put(element, frequencyMap.get(element) + 1);
            } else {
                frequencyMap.put(element, 1);
            }
        }
        return frequencyMap;
    }
}
