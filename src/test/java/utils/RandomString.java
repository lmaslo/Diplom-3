package utils;

import java.util.Random;

public class RandomString {
    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }


    public static String getRandomEmail() {
        String emailDomain = "@yandex.ru";
        return getRandomString(10) + emailDomain;
    }
}