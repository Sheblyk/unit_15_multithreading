package ua.com.multithreading.controller;

import ua.com.multithreading.entity.Horse;
import ua.com.multithreading.entity.Racing;
import ua.com.multithreading.util.Util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRacing {
    public void start() {
        int currentHorse = Util.getInt("Enter your horse (1-10)", 1, 10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Racing racing = new Racing();

        for (int i = 1; i <= 10; i++) {
            executorService.execute(new Horse(racing, i));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(100000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Util.printListAndMessage(racing.getResults(), "");
        System.out.println("Your horse went: " + racing.getCurrentHorsePlace(currentHorse));
    }

}
