package string.problems;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class DuplicateWord {
    public static Map<String, Integer> duplicates(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : str.split("[ .]")) {
            if (s.isEmpty()) {
                continue;
            }
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        Set<String> words = map.keySet();
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
            if (map.get(word) > 1) {
                result.put(word, map.get(word));
            }
        }
        return result;
    }

    public static double wordAverageLength(String str) {
        int sum = 0;
        int cnt = 0;
        for (String s : str.split("[ .]")) {
            if (s.isEmpty()) {
                continue;
            }
            sum += s.length();
            cnt++;
        }
        return (double) sum / cnt;
    }

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        Map<String, Integer> map = duplicates(st);
        for (String string : map.keySet()) {
            System.out.println(string + " " + map.get(string));
        }
        System.out.printf("\nAverage length of words: %.2f\n", wordAverageLength(st));
    }

}

