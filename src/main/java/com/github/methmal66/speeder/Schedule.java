package com.github.methmal66.speeder;

public class Schedule {
    private int wmp;

    /**
     * Store the wpm for future use
     * 
     * @param int Word Per Minute rate
     */
    Schedule(int _wpm) {
        this.wmp = _wpm;
    }

    /**
     * Convert the wpm rate into milli seconds delay
     * 
     * @return int delay of how much time each world should display. Measured in
     *         milli seconds
     */
    public int calculateDelay() {
        final int SECONDS_PER_MINUTE = 60;
        final int MILLIS_PER_SECOND = 1000;
        final double delayInMinutes = 1 / (float) this.wmp;
        final int delayInMillies = (int) Math.ceil(delayInMinutes * SECONDS_PER_MINUTE * MILLIS_PER_SECOND);
        return delayInMillies;
    }

    /**
     * Temporarily print word by word in given fixed delay. Throws
     * InterruptedException when there are any interrupts during the delays
     * 
     * @param words  String[] :Words to be displayed in the terminal
     * @param millis int: Delay Between each word. Measured in milli seconds
     */
    public void printWordsTemporarily(String words[], int millis) throws InterruptedException {
        for (String word : words) {
            System.out.println(word);
            Thread.sleep(millis);
            System.out.print(String.format("\033[%dA", 1)); // Move up
            System.out.print("\033[2K"); // Erase line content
        }
    }
}
