package datastructure;
import databases.ConnectToSqlDB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class DataReader {

	public static void main(String[] args) {
		/*
		 * User API to read the below textFile and print to console.
		 * Use BufferedReader class. 
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */

		String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car";
		try {
			//create database
			ConnectToSqlDB db = new ConnectToSqlDB();
			db.createDatabase("DataReader", new String[]{"words"}, new String[]{"VARCHAR (255)"});
			BufferedReader br = new BufferedReader(new FileReader(new File(textFile)));
			Queue<String> list = new LinkedList<>();
			Stack<String> stack = new Stack<>();
			//insert to database
			String line;
			while ((line = br.readLine()) != null) {
				String toks[] = line.split("[ .,]");
				db.insertDataFromArrayToSqlTable(toks, "DataReader", "words");
			}
			//retrieve from database to list and stack
			for (String s : db.readDataBase("DataReader", "words")) {
				list.add(s);
				stack.push(s);
			}
			//fifo
			System.out.println("FIFO: ");
			Iterator<String> fifo = list.iterator();
			while (fifo.hasNext()) {
				System.out.print(fifo.next() + " ");
			}
			//lifo
			System.out.println("\n\nLIFO:");
			while (!stack.isEmpty()) {
				System.out.print(stack.peek() + " ");
				stack.pop();
			}
			System.out.println("");
		} catch (FileNotFoundException ex) {
			System.err.println("File " + textFile + " not found");
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println(ex.getMessage());
		}
	}

}





