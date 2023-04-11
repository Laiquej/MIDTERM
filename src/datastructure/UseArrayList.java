package datastructure;

import databases.ConnectToSqlDB;
import java.util.ArrayList;
import java.util.Iterator;

public class UseArrayList {

	public static void main(String[] args) throws Exception {
		 /*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 *
		 */
		ArrayList<Integer> list = new ArrayList<>();
		// add 10 random from 1-100
		for (int i = 0; i < 10; i++) {
			list.add((int) (Math.random() * 100 + 1));
		}
		//iterate and insert to database while removing
		ConnectToSqlDB db = new ConnectToSqlDB();
		db.createDatabase("Collections", new String[]{"ArrayList"}, new String[]{"int (11)"});
		System.out.println("\nIterate will adding to database");
		Iterator<Integer> it = list.iterator();
		System.out.print("List: ");
		while (it.hasNext()) {
			int data = it.next();
			db.insertDataFromStringToSqlTable(String.valueOf(data), "Collections", "ArrayList");
			System.out.print(data + " ");
			it.remove();
		}
		System.out.println("\n");
		//print list
		System.out.print("List: ");
		if (list.isEmpty()) {
			System.out.println("Empty");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(0) + " ");
			}
			System.out.println("");
		}
		//retrieve from database
		for (String s : db.readDataBase("Collections", "ArrayList")) {
			list.add(Integer.parseInt(s));
		}
		//loop and retrieve
		System.out.println("\nData Retrieved from database");
		System.out.print("List: ");
		it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println("");
	}

}
