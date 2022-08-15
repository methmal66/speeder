package com.github.methmal66.speeder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandle {
    final String fileName;

    /**
     * Store filename for future use
     * 
     * @param _fileName relative file name
     */
    public FileHandle(String _fileName) {
        this.fileName = _fileName;
    }

    /**
     * Find the absolue file name of a given relative file.
     * 
     * @return String: file name with absolute path
     */
    public String findAbsoluteFileName() {
        final String currentFolder = System.getProperty("user.dir");
        final Path file = Paths.get(currentFolder, fileName);
        return file.toString();
    }

    /**
     * Read a given file and return all the words as an array. Throws IOException
     * when it cannot find the given file
     * 
     * @param filePath String absolute file path
     * 
     * @return String[] words of the file
     * 
     */
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
            return content.replace("\n", " ").split(" ");

        } finally {
            br.close();
        }
    }
}
