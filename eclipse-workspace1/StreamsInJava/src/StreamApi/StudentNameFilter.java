package StreamApi;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StudentNameFilter {

	public static void main(String[] args) {

		List<String> Studentname = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "David", "Andrew", "Eve", "Amanda",
				"George", "Alex");

	//	Scenario: namestatrswithA
		List<String> namestatrswithA = Studentname.stream().filter(name -> name.startsWith("A"))
				.collect(Collectors.toList());

		// Step 3: Print the results
		System.out.println("Names Start with 'A' : " + namestatrswithA);
		
	// Scenario nameswithlength 5
		
		List<String> nameswithSize5 = Studentname.stream().filter(name -> name.length() == 5).collect(Collectors.toList());
		
		System.out.println("Names of size 5:" +nameswithSize5);
		
	// Scenario 3;
		
		List<String> namestatrswithA5 = Studentname.stream().filter(name -> name.startsWith("A") && name.length()==5)
				.collect(Collectors.toList());
		
		System.out.println("Names starts with A and of size 5:" +namestatrswithA5);
		

	}
}