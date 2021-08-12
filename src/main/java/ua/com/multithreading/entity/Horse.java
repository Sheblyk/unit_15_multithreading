package ua.com.multithreading.entity;

import ua.com.multithreading.util.Util;

import static java.lang.Thread.sleep;

public class Horse implements Runnable {
    private int alreadyRun;
    private boolean isRunning = true;
    private final Racing race;
    private final Integer serialNumber;

    public Horse(Racing raceObj, int number) {
        race = raceObj;
        serialNumber = number;
    }

    @Override
    public void run() {
        while (isRunning) {
            alreadyRun += runHorseTime();
            //   System.out.println(Thread.currentThread().getName() + " already run " + alreadyRun);
            if (alreadyRun < 1000) {
                sleepHorse();
                continue;
            }
            race.addResult(serialNumber);
            isRunning = false;
        }
        // System.out.println(Thread.currentThread().getName() + " FINISH");
    }

    private int sleepHorseTime() {
        return Util.generateIntInRange(400, 500);
    }

    private int runHorseTime() {
        return Util.generateIntInRange(100, 200);
    }

    private void sleepHorse() {
        try {
            sleep(sleepHorseTime());
            //    System.out.println(Thread.currentThread().getName() + " sleeping");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
