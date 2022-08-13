package com.github.methmal66.speeder;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String fileName = args[0];
        FileHandle handle = new FileHandle(fileName);
        String file = handle.findAbsoluteFileName();
        System.out.println(file);
    }
}
