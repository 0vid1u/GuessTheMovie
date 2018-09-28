package com.endava.guestthemovie.utils;

import java.util.List;
import java.util.Random;

public class RandomizeUtil {

    public static String getRandomItemFromList(List<String> movies){
        Random rand = new Random();
        return movies.get(rand.nextInt(movies.size()));
    }

}
