package math.problems;

public class Factorial {

    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */

        System.out.println("Factorial Iteration(5): " + factorialIteration(5));
        System.out.println("Factorial Recursion(5): " + factorialRecursion(5));
        System.out.println("Factorial Iteration(8): " + factorialIteration(8));
        System.out.println("Factorial Recursion(8): " + factorialRecursion(8));

    }
        public static long factorialRecursion1(int n) {
            if (n <= 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return n * factorialRecursion(n - 1);
            }
        }

        //Calculate and return factorial using iteration
        public static long factorialIteration(int n) {
            if (n <= 0) {
                return 0;
            }
            int fact = 1;
            for (int i = 2; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }




    static int factorialRecursion(int i) {

        return i;
    }
}

