package com.endava.guestthemovie.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> readFile(String file) {
        List<String> movieList = new ArrayList<>();
        if(isFileExist(file)) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    movieList.add(currentLine);
                }
            } catch (IOException e) {
                System.err.println("IOException: " + e.getMessage());
            }
        } else {
            System.err.println("File not found!");
        }
        return movieList;
    }

    private static boolean isFileExist(String pathAndFileName) {
        File findFile = new File(pathAndFileName);
        return findFile.isFile();
    }

}
