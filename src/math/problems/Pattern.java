package math.problems;

import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		/* Read this numbers, find the pattern then implement the logic from this pattern.which will give you this output.
		 * 100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32............
		 *
		 *
		 */
		 Scanner in = new Scanner(System.in);
		System.out.println("Enter starting number: ");
		int n = in.nextInt();
		int i = 0, dec = 1;
		while (n > 0) {
			n -= dec;
			i++;
			System.out.print(n + ", ");
			if (i == 10) {
				System.out.println("");
				i = 0;
				dec++;
			}
		}
	}
}



