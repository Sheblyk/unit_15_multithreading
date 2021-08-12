package ua.com.multithreading.entity;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Racing {

    private ConcurrentHashMap<Integer, Integer> results;
    private AtomicInteger counter;

    public Racing() {
        results = new ConcurrentHashMap<>();
        counter = new AtomicInteger(1);
    }

    public ConcurrentHashMap<Integer, Integer> getResults() {
        return results;
    }

    public void addResult(int number) {
        results.put(number, counter.getAndIncrement());
    }

    public int getCurrentHorsePlace(int current) {
        return results.get(current);
    }
}

