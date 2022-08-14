package com.github.methmal66.speeder;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        final String fileName = args[0];
        final FileHandle handle = new FileHandle(fileName);
        final String file = handle.findAbsoluteFileName();
        final String words[] = handle.readContentWordByWord(file);

        final int wpm = Integer.parseInt(args[1]);
        final Schedule schedule = new Schedule(wpm, words);
        final int delay = schedule.calculateDelay();
        schedule.printWordsTemporarily(words, delay);
    }
}