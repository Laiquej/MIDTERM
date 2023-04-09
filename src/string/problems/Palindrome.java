package string.problems;

public class Palindrome {
    public static boolean palindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (s.charAt(j) == ' ') {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called Palindrome. For example, MOM,DAD,MADAM are
          Palindrome. So write java code to check if a given String is Palindrome or not.
         */
        System.out.println("Is \"HELLO\" palindrome? " + palindrome("HELLO"));
        System.out.println("Is \"MOM\" palindrome? " + palindrome("MOM"));
        System.out.println("Is \"MADAM\" palindrome? " + palindrome("MADAM"));
        System.out.println("Is \"MAD DUDDAM\" palindrome? " + palindrome("MAD DUDDAM"));

    }
}


