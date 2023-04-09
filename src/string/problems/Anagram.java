package string.problems;

import java.util.Arrays;

public class Anagram {
    public static boolean isAnagram(String s1, String s2) {
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String str1 = new String(c1);
        String str2 = new String(c2);
        return str1.equals(str2);
    }
    public static void main(String[] args) {
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".
            System.out.println("\"CAT\" and \"ACT\" ? " + isAnagram("CAT", "ACT"));
            System.out.println("\"HAT\" and \"ACT\" ? " + isAnagram("HAT", "ACT"));
            System.out.println("\"ARMY\" and \"MARY\" ? " + isAnagram("ARMY", "MARY"));
            System.out.println("\"ARMY\" and \"MORY\" ? " + isAnagram("ARMY", "MORY"));

    }
}
