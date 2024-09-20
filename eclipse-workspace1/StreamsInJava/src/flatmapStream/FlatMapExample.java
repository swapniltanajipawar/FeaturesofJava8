package flatmapStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

	public static void main(String[] args) {
		  // List of students with their subjects
		
		List<Student> students = Arrays.asList(
				new Student("Alice", Arrays.asList("Math","Physics")),
				new Student("Anna", Arrays.asList("History","Physics")),
				new Student("Aniket", Arrays.asList("Math","Geo")),
				new Student("Anamika", Arrays.asList("Marathi","German")),
				new Student("Andy", Arrays.asList("Japanees","Geo")),
				new Student("Abhi", Arrays.asList("Socio","Hindi")),
				new Student("Ashu", Arrays.asList("Panjabi","Kanada")));			

		// Using map() - This will return a Stream of List<String>
		List<List<String>> subjectsList = students.stream().map(Student::getSubjects).collect(Collectors.toList());
		System.out.println("Stream of Lists:"+subjectsList);
		
		//flatMap() helps you flatten the stream by merging all the inner collections into a single stream.
        //It transforms each element into a stream and then merges (flattens) all streams into a single stream.
		// If you have a collection of collections and want to process the inner elements as a single stream.
		
		List<String> subjectList = students.stream().flatMap(student -> student.getSubjects().stream()).collect(Collectors.toList());
		System.out.println("Flattened List of Subject:"+ subjectList);

		
	}

}
