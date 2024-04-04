package ua.foxminded.ui;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class CounterFormatter {

    private StringBuilder result;

    public StringBuilder splitLinkedHashMap(@NotNull Map<Character, Integer> linkedHashMap) {
        result = new StringBuilder();
        for (Map.Entry<Character, Integer> mapElement : linkedHashMap.entrySet()) {
            int value = mapElement.getValue();
            String key = String.valueOf(mapElement.getKey());
            resultInput(value, key);
        }
        return result;
    }

    private void resultInput(int value, String key) {
        result.append("\"").append(key).append("\"").append(" - ").append(value).append("\n");
    }

}
