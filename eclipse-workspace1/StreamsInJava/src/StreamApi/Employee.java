package StreamApi;
import java.util.ArrayList;
import java.util.List;

public class  Employee{
	
	int id;
	String Empname;
	double Salary;
	
	public Employee(int id, String Empname, double Salary)
	{
		this.id =id;
		this.Empname = Empname;
		this.Salary = Salary;
	}

	public static void main(String[] args) {
			List<Employee> employeeList = new ArrayList<Employee>();
			employeeList.add(new Employee(1,"Swapnil", 10000.00));
			employeeList.add(new Employee(2, "Swati", 50000.00)); 
			employeeList.add(new Employee(3, "Swami", 600000.00));
			employeeList.add(new Employee(4, "Suvarna", 70000.00));			
		}

}
