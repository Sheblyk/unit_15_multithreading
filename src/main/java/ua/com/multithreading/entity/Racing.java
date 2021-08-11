package ua.com.multithreading.entity;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Integer> results;

    public Racing() {
        results = new ArrayList<>();
    }

    public List<Integer> getResults() {
        return results;
    }

    public void addResult(int number) {
        results.add(number);
    }

    public int getCurrentHorsePlace(int current) {
        return results.indexOf(current) + 1;
    }
}

