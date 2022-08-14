package com.github.methmal66.speeder;

import java.io.IOException;
import org.apache.commons.cli.ParseException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        final Command cmd = new Command(args);

        final String fileName = cmd.parseFile();
        final FileHandle handle = new FileHandle(fileName);
        final String file = handle.findAbsoluteFileName();
        final String words[] = handle.readContentWordByWord(file);

        final int wpm = cmd.parseWPM();
        final Schedule schedule = new Schedule(wpm, words);
        final int delay = schedule.calculateDelay();
        schedule.printWordsTemporarily(words, delay);
    }
}