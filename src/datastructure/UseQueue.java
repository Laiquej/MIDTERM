
package datastructure;

import databases.ConnectToSqlDB;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) throws Exception {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 */
		Queue<Integer> list = new LinkedList<>();
		// add 10 random from 1-100
		for (int i = 0; i < 10; i++) {
			list.offer((int) (Math.random() * 100 + 1));
		}
		//iterate and insert to database while removing
		ConnectToSqlDB db = new ConnectToSqlDB();
		db.createDatabase("Collections", new String[]{"Queue"}, new String[]{"int (11)"});
		System.out.println("\nIterate will adding to database");
		Iterator<Integer> it = list.iterator();
		System.out.print("Queue: ");
		while (it.hasNext()) {
			int data = it.next();
			db.insertDataFromStringToSqlTable(String.valueOf(data), "Collections", "Queue");
			System.out.print(data + " ");
			it.remove();
		}
		System.out.println("\n");
		//print list
		System.out.print("Queue: ");
		if (list.isEmpty()) {
			System.out.println("Empty");
		} else {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				System.out.print(list.peek() + " ");
				list.offer(list.poll());
			}
			System.out.println("");
		}
		//retrieve from database
		for (String s : db.readDataBase("Collections", "Queue")) {
			list.offer(Integer.parseInt(s));
		}
		//loop and retrieve
		System.out.println("\nData Retrieved from database");
		System.out.print("Queue: ");
		it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println("");
	}

}
