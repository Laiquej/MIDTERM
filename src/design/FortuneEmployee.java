package design;
import databases.ConnectToSqlDB;
import java.util.List;

public class FortuneEmployee {

	/**
	 * FortuneEmployee class has a main methods where you will be able to create
	 * Object from EmployeeInfo class to use fields and attributes.Demonstrate
	 * as many methods as possible to use with proper business work flow.Think
	 * as a Software Architect, Product Designer and as a Software
	 * Developer.(employee.info.system) package is given as an outline,you need
	 * to elaborate more to design an application that will meet for fortune 500
	 * Employee Information Services.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve
	 * data.
	 *
	 *
	 */
	public static void main(String[] args) throws Exception {
		Employee emp1 = new EmployeeInfo(1, "John", "HR");
		Employee emp2 = new EmployeeInfo(2, "Mike", "Finance");
		Employee emp3 = new EmployeeInfo(3, "Bruce");
		emp3.setName("Anabbil");
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
		//insert to database
		System.out.println("\nInsert into database");
		ConnectToSqlDB db = new ConnectToSqlDB();
		db.createDatabase("Employees", new String[]{"ID", "Name", "Department"},
				new String[]{"int(10)", "varchar(255)", "varchar(255)"});
		db.insertDataFromEmployeeToSqlTable(emp1, "Employees");
		db.insertDataFromEmployeeToSqlTable(emp2, "Employees");
		db.insertDataFromEmployeeToSqlTable(emp3, "Employees");
		//retrieve from database and print
		List<Employee> emps = db.readEmployeeProfileFromSqlTable();
		System.out.println("Retrieved data from databsase");
		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}

}