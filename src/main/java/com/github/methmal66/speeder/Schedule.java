package com.github.methmal66.speeder;

public class Schedule {
    private int wmp;

    Schedule(int _wpm, String[] words) {
        this.wmp = _wpm;
    }

    public int calculateDelay() {
        final int SECONDS_PER_MINUTE = 60;
        final int MILLIS_PER_SECOND = 1000;
        final double delayInMinutes = 1 / (float) this.wmp;
        final int delayInMillies = (int) Math.ceil(delayInMinutes * SECONDS_PER_MINUTE * MILLIS_PER_SECOND);
        return delayInMillies;
    }

    public void printWordsTemporarily(String words[], int millis) throws InterruptedException {
        for (String word : words) {
            System.out.println(word);
            Thread.sleep(millis);
            System.out.print(String.format("\033[%dA", 1)); // Move up
            System.out.print("\033[2K"); // Erase line content
        }
    }
}
