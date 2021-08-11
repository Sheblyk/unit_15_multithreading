package ua.com.multithreading.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Util {
    private static final Random RANDOM = new Random();

    public static Set<Integer> uniqueRandom(int n, int k) {
        final Set<Integer> unique = new HashSet<>();
        while (unique.size() < n) {
            unique.add(RANDOM.nextInt(k + 1));
        }
        return unique;
    }

    public static <E> void printListAndMessage(List<E> list, String message) {
        System.out.println(message);
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println("\n");
    }

    public static int generateIntInRange(int from, int to) {
        return (int) (from + Math.random() * (to - from));
    }

    public static int getInt(String message, int from, int to) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(message);
        int res;
        while (true) {
            try {
                res = Integer.parseInt(reader.readLine());
                if (res >= from && res <= to) {
                    return res;
                }
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Something went wrong! Please, enter your choice once more");
            }
        }
    }
}

