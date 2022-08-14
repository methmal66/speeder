package com.github.methmal66.speeder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public String[] readContentWordByWord(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            final String content = sb.toString();
            return content.split(" ");

        } finally {
            br.close();
        }
    }
}
