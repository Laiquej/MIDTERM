package string.problems;

import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {
    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s = "Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);
        //implement
        for (Integer i : wordNLength.keySet()) {
            System.out.println(i + " " + wordNLength.get(i));
        }
    }
    public static Map<Integer, String> findTheLargestWord(String wordGiven){
        Map<Integer, String> map = new HashMap<Integer, String>();
            String maxWord = "";
            for (String string : wordGiven.split(" ")) {
                if (string.length() > maxWord.length()) {
                    maxWord = string;
                }
            }
            map.put(maxWord.length(), maxWord);
            return map;
        }
    }