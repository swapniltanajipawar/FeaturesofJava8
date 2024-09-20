package streamAll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamStudentExample {

	public static void main(String[] args) {

		// List of 10 students with names and marks

		List<Student> student = new ArrayList<Student>();
		student.add(new Student("Aniket", 100));
		student.add(new Student("Anu", 99));
		student.add(new Student("Anuja", 88));
		student.add(new Student("Anita", 78));
		student.add(new Student("Tnkur", 65));
		student.add(new Student("Mndy", 55));
		student.add(new Student("Bnnadsss", 88));
		student.add(new Student("Anamika", 63));
		student.add(new Student("Anushila", 93));
		student.add(new Student("Anmol", 0));

		// Filter names starting with 'A' or with a length of 5
		List<Student> filterednamewithA5 = student.stream()
				.filter(students -> students.getName().startsWith("A") && students.getName().length() == 5)
				.collect(Collectors.toList());
		filterednamewithA5.forEach(System.out::println);

		System.out.println("------------------------------------------------");

		// Mapping student names to uppercase and sorting them
		List<String> uppersort = student.stream().map(students -> students.getName().toUpperCase()).sorted()
				.collect(Collectors.toList());
		uppersort.forEach(System.out::println);

		System.out.println("------------------------------------------------");
		// Finding first student whose name starts with 'A'
		Optional<Student> firstStudent = student.stream().filter(students -> students.getName().startsWith("A"))
				.findFirst();
		firstStudent.ifPresent(
				student1 -> System.out.println("Finding first student whose name starts with 'A'" + student1));

		System.out.println("------------------------------------------------");
		// Finding any student whose name starts with 'A' in parallel
		Optional<Student> anyStudent = student.parallelStream().filter(students -> students.getName().startsWith("A"))
				.findAny();
		anyStudent.ifPresent(students -> System.out
				.println("Finding any student whose name starts with 'A' in parallel" + anyStudent));

		System.out.println("------------------------------------------------");
		// Exception Handling in Streams (Dividing marks by 0, if possible)
		List<Integer> safemarks = student.stream().map(students -> {
			try {
				return 100 / students.getMarks();
			} catch (ArithmeticException ae) {
				System.err.println("Error: Division by zero for student " + students.getName());
				return 0; // Returning 0 when division by zero occurs
			}
		}).collect(Collectors.toList());
		safemarks.forEach(System.out::println);

		System.out.println("------------------------------------------------");
		 // Converting List to Map with name as key and marks as value
		//Map<String, Integer> map1 = student.stream().collect(Collectors.toMap(Students ->Students.getName(), Students -> Students.getMarks()));
		Map<String, Integer> map1 = student.stream().collect(Collectors.toMap(Student::getName , Student::getMarks));
		map1.forEach((name, marks)-> System.out.println(name+"->"+marks));
		
		  // Converting Map back to List of Students
		 List<Student> mapToList = map1.entrySet().stream().map(entry -> new Student(entry.getKey(), entry.getValue())).collect(Collectors.toList());
	        mapToList.forEach(System.out::println);
	        
	        // Sorting students by marks using Stream
	        List<Student> sortedByMarks = student.stream().sorted(Comparator.comparingInt(Student::getMarks)).collect(Collectors.toList());
	        System.out.println("\nStudents Sorted by Marks:");
	        sortedByMarks.forEach(System.out::println);
	        
//	        The forEach method is a terminal operation provided by the Iterable interface in Java. It is used to iterate over each element of the collection (in this case, the sortedByMarks list).
//	        The forEach method accepts a consumer, which is a functional interface that takes an argument (in this case, each Student object) and performs an operation on it.
//	        sortedByMarks.forEach(student -> System.out.println(student));
//	        This iterates over each Student object in sortedByMarks and prints it to the console.
	}
}
