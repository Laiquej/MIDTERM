package string.problems;
import java.io.IOException;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class UnitTestingStringProblem {
    @Test
    public static void testAnagram() {
        System.out.println("Testing Anagram");
        Assert.assertTrue(Anagram.isAnagram("CAT", "ACT"));
        Assert.assertFalse(Anagram.isAnagram("HAT", "ACT"));
        Assert.assertTrue(Anagram.isAnagram("ARMY", "MARY"));
        Assert.assertFalse(Anagram.isAnagram("ARMY", "MORY"));
        System.out.println("Anagram tests passed\n");
    }
    @Test
    public static void testLargestWord() {
        System.out.println("Testing DetermineLargestWord");
        String s1 = "hello world I'm back from the future";
        String s2 = "Human brain is a biological learning machine";
        Map<Integer, String> m1 = DetermineLargestWord.findTheLargestWord(s1);
        Map<Integer, String> m2 = DetermineLargestWord.findTheLargestWord(s2);
        Assert.assertEquals(m1.toString(), "{6=future}");
        Assert.assertEquals(m2.toString(), "{10=biological}");
        System.out.println("DetermineLargestWord tests passed\n");
    }
    @Test
    public static void testDuplicateWord() {
        System.out.println("Testing DuplicateWord");
        String s1 = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        Map<String, Integer> map = DuplicateWord.duplicates(s1);
        Assert.assertEquals(map.toString(), "{Java=3, is=3}");
        Assert.assertEquals(DuplicateWord.wordAverageLength(s1), 4.65, 0.01);
        System.out.println("DuplicateWord tests passed\n");
    }

    @Test
    public static void testPalindrome() {
        System.out.println("Testing Palindrome");
        Assert.assertTrue(Palindrome.palindrome("MADAM"));
        Assert.assertTrue(Palindrome.palindrome("MOM"));
        Assert.assertFalse(Palindrome.palindrome("HELLO"));
        Assert.assertFalse(Palindrome.palindrome("HAT"));
        System.out.println("Palindrome tests passed\n");
    }

    @Test
    public static void testPermutation() {
        System.out.println("Testing Permutation");
        Assert.assertEquals(Permutation.permutation("CAT"), "CAT CTA ACT ATC TCA TAC");
        Assert.assertEquals(Permutation.permutation("ABC"), "ABC ACB BAC BCA CAB CBA");
        System.out.println("Permutation tests passed\n");
    }

    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.
        try {
            testAnagram();
            testLargestWord();
            testDuplicateWord();
            testPalindrome();
            testPermutation();
        } catch (Exception ex) {
            System.out.println("Some tests failed");
            System.out.println(ex.getMessage());
        }
    }
}

