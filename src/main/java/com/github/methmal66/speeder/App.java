package com.github.methmal66.speeder;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileHandle handle = new FileHandle(fileName);
        String file = handle.findAbsoluteFileName();
        String words[] = handle.readContentWordByWord(file);

        for (String word : words) {
            System.out.println(word);
        }
    }
}