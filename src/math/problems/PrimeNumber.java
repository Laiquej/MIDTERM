package math.problems;
import databases.ConnectToSqlDB;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PrimeNumber {
	public static int[] findPrimes(int n) {
		boolean[] numbers = new boolean[n + 1];
		Arrays.fill(numbers, true);
		int cnt = n;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (numbers[i]) {
				int j = i * i;
				while (j <= n) {
					numbers[j] = false;
					j += i;
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (numbers[i]) {
				list.add(i);
			}
		}
		int[] arr = new int[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}


	public static void main(String[] args) throws Exception {
		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 *
		 */
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		int num[] = (int[]) findPrimes(1000000);
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "primes", "PrimeNumber");
		printValue(connectToSqlDB.readDataBase("primes", "PrimeNumber"));
	}

	 private static void printValue(List<String> array) {
		for (String st : array) {
			System.out.println(st);
		}
	}

}
