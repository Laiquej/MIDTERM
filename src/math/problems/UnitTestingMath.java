package math.problems;
import org.junit.Assert;
public class UnitTestingMath {
    public static void main(String[] args) {
        //Apply Unit testing into each classes and methods in this package.
        Assert.assertEquals(Factorial.factorialIteration(5), 120);
        Assert.assertEquals(Factorial.factorialRecursion(5), 120);
        Assert.assertEquals(Factorial.factorialIteration(8), 40320);
        Assert.assertEquals(Factorial.factorialRecursion(8), 40320);
        System.out.println("Factorial tests passed.");
        //Fibonacci
        System.out.println("\nTesting Fibonacci");
        int[] fib1 = {0, 1, 1, 2, 3};
        int[] fib2 = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986};
        Assert.assertArrayEquals(Fibonacci.fibonacci(5), fib1);
        Assert.assertArrayEquals(Fibonacci.fibonacci(40), fib2);
        System.out.println("Fibonacci tests passed.");
        //LowestDifference
        System.out.println("\nTesting LowestDifference");
        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19};
        int[] array3 = {40};
        Assert.assertEquals(FindLowestDifference.lowestDifference(array1, array2), 1, 0);
        Assert.assertEquals(FindLowestDifference.lowestDifference(array1, array3), 7, 0);
        System.out.println("LowestDifference tests passed.");
        //MissingNumber
        System.out.println("\nTesting MissingNumber");
        int[] miss1 = {10, 2, 9, 4, 5, 3, 1, 8, 6};
        int[] miss2 = {10, 2, 7, 4, 5, 3, 1, 8, 6};
        int[] miss3 = {10, 2, 9, 4, 5, 7, 1, 8, 6};
        Assert.assertEquals(FindMissingNumber.missingNumber(miss1), 7);
        Assert.assertEquals(FindMissingNumber.missingNumber(miss2), 9);
        Assert.assertEquals(FindMissingNumber.missingNumber(miss3), 3);
        System.out.println("MissingNumber tests passed.");
        //MakePyramid
        System.out.println("\nTesting LowestNumber");
        int low1[] = {5, 3, 1};
        int low2[] = {5, 2, 3};
        Assert.assertEquals(LowestNumber.lowest(low1), 1);
        Assert.assertEquals(LowestNumber.lowest(low2), 2);
        System.out.println("LowestNumber tests passed.");
        //PrimeNumber
        System.out.println("\nTesting PrimeNumber");
        int[] primes1 = {2, 3, 5, 7};
        int[] primes2 = {2, 3, 5, 7, 11, 13, 17, 19};
        Assert.assertArrayEquals(PrimeNumber.findPrimes(10), primes1);
        Assert.assertArrayEquals(PrimeNumber.findPrimes(20), primes2);
        System.out.println("PrimeNumber tests passed.");

    }
}


