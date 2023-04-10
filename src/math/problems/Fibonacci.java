package math.problems;

public class Fibonacci {
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
          0,1,1,2,3,5,8,13
         */


    }
     public static int[] fibonacci(int n) {
        int fib[] = new int[n];
        int f1 = 0, f2 = 1, tmp;
        for (int i = 0; i < n; i++) {
            fib[i] = f1;
            tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }
        return fib;
    }

}
