package design;

public interface Employee {
	//please read the following method and understand the business requirements of these following methods
	//and then implement these in a concrete class.
	//getId() will return employee id.
	public int getId();

	//setId() will change employee id.
	public void setId(int id);

	//getName() will return employee name
	public String getName();

	//setName() will change employee id
	public void setName(String name);

	//assignDepartment() will assign employee to departments
	public void assignDepartment(String department);

	//getDepartment() will return department
	public String getDepartment();

	//calculate employee salary
	public double calculateSalary();

	//employee benefit
	public void benefitLayout();

}