package ua.foxminded.ui;

import org.junit.jupiter.api.Test;
import ua.foxminded.domain.Storage;
import ua.foxminded.service.CounterManager;
import ua.foxminded.service.CounterService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CounterFormatterTest {
    private CounterFormatter counterFormatter = new CounterFormatter();
    private Storage storage = new Storage();
    private CounterService counterService = new CounterService();
    private CounterManager counterManager = new CounterManager(storage, counterService);

    @Test
    void splitLinkedHashMap_shouldReturnEmptyString_whenInputIsEmptyString() {
        String actual = String.valueOf(counterFormatter.splitLinkedHashMap(counterManager.checkManager("")));
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void splitLinkedHashMap_shouldReturnAllActionsInAString_whenTheInputIsSpace() {
        String actual = String.valueOf(counterFormatter.splitLinkedHashMap(counterManager.checkManager(" ")));
        String expected = "\" \" - 1\n";
        assertEquals(expected, actual);
    }

    @Test
    void splitLinkedHashMap_shouldCountReturnTheCorrectlyCountedNumberOfCharactersInOneRow_ifTheSameCharactersArrive() {
        String actual = String.valueOf(counterFormatter.splitLinkedHashMap(counterManager.checkManager("aaaa")));
        String expected = "\"a\" - 4\n";
        assertEquals(expected, actual);
    }

    @Test
    void splitLinkedHashMap_shouldReturnTheCorrectlyCountedCharactersInLowerCase_whenTheInputContainsLowerCaseWord() {
        String actual = String.valueOf(counterFormatter.splitLinkedHashMap(counterManager.checkManager("hello")));
        String expected = "\"h\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 2\n" +
                "\"o\" - 1\n";
        assertEquals(expected, actual);
    }

    @Test
    void splitLinkedHashMap_shouldReturnAllCharactersIncludingPunctuation_ifTypedIntoAString() {
        String actual = String.valueOf(counterFormatter.splitLinkedHashMap(counterManager.checkManager("Hi Yaroslav. How are you?")));
        String expected = "\"H\" - 2\n" +
                "\"i\" - 1\n" +
                "\" \" - 4\n" +
                "\"Y\" - 1\n" +
                "\"a\" - 3\n" +
                "\"r\" - 2\n" +
                "\"o\" - 3\n" +
                "\"s\" - 1\n" +
                "\"l\" - 1\n" +
                "\"v\" - 1\n" +
                "\".\" - 1\n" +
                "\"w\" - 1\n" +
                "\"e\" - 1\n" +
                "\"y\" - 1\n" +
                "\"u\" - 1\n" +
                "\"?\" - 1\n";
        assertEquals(expected, actual);
    }

    @Test
    void put_shouldReturnTheCorrectlyCalculatedResultOfOneWord_ifTheCalculatedResultIsAlreadyInTheCache() {
        Map<Character, Integer> map = counterService.linkedHasMapInput("hello");
        storage.put("hello", map);
        Map<Character, Integer> map1 = storage.get("hello");
        assertEquals(map, map1);
    }

}