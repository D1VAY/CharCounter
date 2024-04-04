package ua.foxminded;

import ua.foxminded.domain.Storage;
import ua.foxminded.service.CounterManager;
import ua.foxminded.service.CounterService;
import ua.foxminded.ui.CounterFormatter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "";

        Storage storage = new Storage();
        CounterService counterService = new CounterService();
        CounterManager counterManager = new CounterManager(storage, counterService);
        CounterFormatter counterFormatter = new CounterFormatter();
        while (true) {
            line = sc.nextLine();
            if (line.equals("STOP")) {
                break;
            } else {
                System.out.println(counterFormatter.splitLinkedHashMap(counterManager.checkManager(line)));
            }
        }

        sc.close();

    }
}
