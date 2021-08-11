package ua.com.multithreading;

import ua.com.multithreading.controller.HorseRacing;

public class Main {

    public static void main(String[] args) {
        HorseRacing horseRacing = new HorseRacing();
        horseRacing.start();
    }
}

