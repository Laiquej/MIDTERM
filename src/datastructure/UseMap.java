package datastructure;

import databases.ConnectToSqlDB;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseMap {

	public static void main(String[] args) throws Exception {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> list1 = new ArrayList<>(Arrays.asList(new String[]{"Java", "Cpp", "Python"}));
		List<String> list2 = new ArrayList<>(Arrays.asList("Encapsulation", "Polymerphism", "Inheritance", "Abstraction"));
		List<String> list3 = new ArrayList<>(Arrays.asList(new String[]{"Arrays", "LinkedList", "Queue", "Stack", "Priority Queue"}));
		List<String> list4 = new ArrayList<>(Arrays.asList(new String[]{"Insertion Sort", "Selection Sort", "Bubble Sort"}));
		map.put("Programming Languages", list1);
		map.put("OOP Concepts", list2);
		map.put("Data Structures", list3);
		map.put("Sorting Algorithms", list4);
		//Print map while inserting to database
		ConnectToSqlDB db = new ConnectToSqlDB();
		db.createDatabase("Map", new String[]{"map_key", "map_val"}, new String[]{"VARCHAR (255)", "VARCHAR(255)"});
		System.out.println("\nMap Contents");
		for (String key : map.keySet()) {
			db.insertDataFromMapToSqlTable(key, map.get(key).toString(), "Map");
			System.out.println("key: " + key + ", values: " + map.get(key));
		}
		//clea and print map
		map.clear();
		System.out.println("\nMap is cleared");
		System.out.println("Map: " + map.toString());
		//retrieve data from database
		List<String> keys = db.readDataBase("Map", "map_key");
		List<String> values = db.readDataBase("Map", "map_val");
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			map.put(key, new ArrayList<>());
			for (String val : values.get(i).substring(1, values.get(i).length() - 1).split("[ ,]")) {
				if (!val.isEmpty()) {
					map.get(key).add(val);
				}
			}
		}
		//print map
		System.out.println("\nData retrieved");
		for (String key : map.keySet()) {
			System.out.println("key: " + key + ", values: " + map.get(key));
		}
	}

}