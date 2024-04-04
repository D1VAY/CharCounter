package ua.foxminded.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.foxminded.domain.Storage;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CounterManagerTest {
    @Mock
    private Storage storage;
    @Mock
    private CounterService counterService;
    @InjectMocks
    private CounterManager counterManager;

    @Test
    void isPresent_shouldReturnTrue_ifACertainCacheLineArrives() {
        when(storage.isPresent("hello")).thenReturn(true);
        assertEquals(storage.isPresent("hello"), true);
    }

    @Test
    void linkedHasMapInput_shouldReturnAMapWithTheNumberOfCharacters_ifACertainStringComesIntoTheMethod() {
        CounterService counterService1 = new CounterService();
        Map<Character, Integer> map = counterService1.linkedHasMapInput("hello");
        when(counterService.linkedHasMapInput("hello")).thenReturn(map);
        assertEquals(counterService.linkedHasMapInput("hello"), map);
    }

    @Test
    void linkedHasMapInput_shouldNotCallTheServiceMethod_ifTheValueIsInTheCache() {
        when(storage.isPresent("hello")).thenReturn(true);
        Map<Character, Integer> map = counterManager.checkManager("hello");
        assertEquals(counterManager.checkManager("hello"), map);

        verify(counterService, times(0)).linkedHasMapInput("hello");

    }

    @Test
    void linkedHasMapInput_shouldCallTheServiceMethod_ifTheValueIsNotInTheCache() {
        when(storage.isPresent("hello")).thenReturn(false);
        Map<Character, Integer> map = counterManager.checkManager("hello");
        assertEquals(counterManager.checkManager("hello"), map);

        verify(counterService, times(2)).linkedHasMapInput("hello");
    }


}
