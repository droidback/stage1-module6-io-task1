package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile;
        StringBuilder sb = new StringBuilder();

        try (FileInputStream in = new FileInputStream(file)) {
            int ch;
            while ((ch = in.read()) != -1) {
                sb.append((char) ch);
            }

            String[] lines = sb.toString().split("\n");
            int size = lines.length;
            for (int i = 0; i < size; i++) {
                String line = lines[i];
                lines[i] = line.substring(line.indexOf(':') + 1).trim();
            }
            profile = new Profile(lines[0], Integer.parseInt(lines[1]), lines[2], Long.parseLong(lines[3]));
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        return profile;
    }
}
