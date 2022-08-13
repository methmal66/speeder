package com.github.methmal66.speeder;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandle {
    final String fileName;

    public FileHandle(String _fileName) {
        this.fileName = _fileName;
    }

    public String findAbsoluteFileName() {
        final String currentFolder = System.getProperty("user.dir");
        final Path file = Paths.get(currentFolder, fileName);
        return file.toString();
    }
}
