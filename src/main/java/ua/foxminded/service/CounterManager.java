package ua.foxminded.service;

import ua.foxminded.domain.Storage;

import java.util.HashMap;
import java.util.Map;

public class CounterManager {
    private Storage storage;
    private CounterService counterService;
    private Map<Character, Integer> map = new HashMap<>();

    public CounterManager() {

    }

    public CounterManager(Storage storage, CounterService counterService) {
        this.storage = storage;
        this.counterService = counterService;
    }

    public Map<Character, Integer> checkManager(String line) {
        if (storage.isPresent(line)) {
            map = storage.get(line);
            return map;
        } else {
            map = counterService.linkedHasMapInput(line);
            storage.put(line, map);
            return map;
        }
    }

}
