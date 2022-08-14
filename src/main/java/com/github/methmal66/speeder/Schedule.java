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
}
