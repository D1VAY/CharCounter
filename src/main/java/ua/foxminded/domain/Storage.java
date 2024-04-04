package ua.foxminded.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Storage {
    private final LinkedHashMap<String, Map<Character, Integer>> cache = new LinkedHashMap<>();

    public boolean isPresent(String data) {
        return cache.containsKey(data);
    }

    public void put(String inp, Map<Character, Integer> map) {
        cache.put(inp, map);
    }

    public Map<Character, Integer> get(String inp) {
        return cache.get(inp);
    }

}
