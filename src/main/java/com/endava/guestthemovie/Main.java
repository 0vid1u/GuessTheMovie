package com.endava.guestthemovie;

import com.endava.guestthemovie.models.Letter;
import com.endava.guestthemovie.utils.FileUtil;
import com.endava.guestthemovie.utils.RandomizeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static LinkedList<Letter> mask;
    private static final int maxRetry = 10;

    public static void main(String[] args) {

        Character letter;
        int retry = 0;

        //1. Read file
        List<String> movies = FileUtil.readFile("./src/movies.txt");

        //2. Select random movie
        String movie = RandomizeUtil.getRandomItemFromList(movies);

        //3. Start Game
        mask = initMask(movie);

        while (!isGameOver()) {
            System.out.println(printMask());
            letter = readLetter();

            if (isLetterInMask(letter)) {
                if (isGameOver()) {
                    System.out.println(printMask());
                    System.out.println("Game Over!");
                    break;
                }
            } else {
                System.out.println("Please retry. " + (maxRetry - retry) + " attempt.");
                retry++;
            }
        }
    }

    private static Character readLetter() {
        System.out.println("Enter a letter: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next(".").charAt(0);
    }

    private static LinkedList<Letter> initMask(String s) {
        LinkedList<Letter> mask = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            mask.add(new Letter(ch, ch != ' '));
        }
        return mask;
    }

    private static String printMask() {
        StringBuilder stringBuilder = new StringBuilder();
        mask.forEach(letter -> {
            if (letter.getHidden()) {
                stringBuilder.append("-");
            } else {
                stringBuilder.append(letter.getLetter());
            }
        });
        return stringBuilder.toString();
    }

    private static boolean isLetterInMask(Character character) {
        boolean isGuest = false;
        for (int i = 0; i < mask.size(); i++) {
            Letter letter = mask.get(i);
            if (letter.getLetter().equals(character) && letter.getHidden()) {
                letter.setHidden(false);
                mask.set(i, letter);
                isGuest = true;
            }
        }
        return isGuest;
    }

    private static boolean isGameOver() {
        for (Letter letter : mask) {
            if (letter.getHidden()) {
                return false;
            }
        }
        return true;
    }
}
