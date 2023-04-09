package string.problems;

public class Permutation {
    public static String permutation(String s) {
        return permutation(s, "").trim();
    }

    private static String permutation(String str, String res) {
        if (str.isEmpty()) {
            return res + " ";
        } else {
            String out = "";
            for (int i = 0; i < str.length(); i++) {
                out += permutation(str.substring(0, i) + str.substring(i + 1),
                        res + str.charAt(i));
            }
            return out;
        }
    }
    public static void main(String[] args) {

        /*
         * Permutation of String "ABC" is "ABC" "BAC" "BCA" "ACB" "CAB" "CBA".
         * Write Java program to compute all Permutation of a String
         *
         */
        System.out.println("Permutation of \"ABC\": " + permutation("ABC"));
        System.out.println("Permutation of \"CAT\": " + permutation("CAT"));
    }
}
