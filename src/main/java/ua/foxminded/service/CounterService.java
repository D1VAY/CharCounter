package ua.foxminded.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class CounterService {
    private final LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();

    public Map<Character, Integer> linkedHasMapInput(String counterLine) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        char charLine;
        Integer counter;
        char[] inputAsCharArray = counterLine.toCharArray();
        for (int i = 0; i < inputAsCharArray.length; i++) {
            charLine = inputAsCharArray[i];
            counter = countMap.get(charLine);
            if (counter != null) {
                countMap.put(charLine, counter + 1);
            } else {
                countMap.put(charLine, 1);
            }
        }
        return countMap;
    }

}
