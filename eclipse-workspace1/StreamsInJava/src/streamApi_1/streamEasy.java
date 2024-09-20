package streamApi_1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class streamEasy {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Jane", "Mark", "Tom", "Jerry", "Alice");

		// Filter names with length > 3, map to uppercase, sort, and find first
		List<String> filter1 = names.stream().filter(name -> name.length() > 3).collect(Collectors.toList());
		System.out.println(filter1);

		List<String> upper = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upper);

		List<String> sort = names.stream().sorted().collect(Collectors.toList());
		System.out.println(sort);

		Optional<String> first = names.stream().findFirst();
		System.out.println(first.isEmpty());
		System.out.println(first);
		System.out.println(first.isPresent());

		// .map(String::toUpperCase)
		// .sorted()
		// .findFirst(); // findFirst returns an Optional

		// first.ifPresent(System.out::println); // Output: ALICE

		// Find any element that satisfies the condition (with parallel stream)
		Optional<String> any = names.parallelStream().filter(name -> name.length() > 1).findAny();

		any.ifPresent(System.out::println); // Output: Could be any valid result
		

		// Using parallel stream to sum numbers in range 1 to 1000
		//Parallel Stream: Finds any name longer than 3 characters using parallel processing.
		//parallelStream(): This converts the stream into a parallel stream, enabling parallel processing.
		//Parallel Streams work by dividing the input into multiple chunks and processing them on multiple threads. This can make operations faster on multi-core CPUs.
		//Parallel streams internally use the ForkJoinPool for splitting and merging tasks.
		int sum = IntStream.rangeClosed(1, 1000).parallel() // Convert to parallel stream
				.sum();

		System.out.println("Sum: " + sum); // Output: Sum: 500500
		
		  List<String> namesStartingWithA = names.parallelStream()
	                .filter(name -> name.startsWith("A"))
	                .map(String::toUpperCase)  // Convert to uppercase and fetch
	                .collect(Collectors.toList()); //collect the result in the list

	        // Print the result
	        System.out.println("Names starting with A (Parallel Processing): " + namesStartingWithA);
		
		
		
		
		

		List<String> nam = Arrays.asList("John", "Jane", "Mark", "Alice");

		// Convert List to Map with name as key and length as value
		Map<String, Integer> map = nam.stream().collect(Collectors.toMap(Function.identity(), String::length));

		System.out.println(map);

		// Convert Map to List (Extracting keys or values)
		Map<String, Integer> nameLengthMap = Map.of("John", 4, "Jane", 4, "Mark", 4, "Alice", 5);
		List<String> keys = nameLengthMap.keySet().stream().collect(Collectors.toList());
		List<Integer> values = nameLengthMap.values().stream().collect(Collectors.toList());
		System.out.println("Keys: " + keys); // Output: [John, Jane, Mark, Alice]
		System.out.println("Values: " + values); // Output: [4, 4, 4, 5]
		
		
		

		// Exception handling in streams:
		List<Integer> numbers = Arrays.asList(1, 2, 0, 3, 4);

		numbers.stream().map(num -> {
			try {
				return 10 / num; // Handle division by zero
			} catch (ArithmeticException e) {
				System.err.println("Arithmetic Exception: Division by Zero!");
				return 0; // Return default value in case of exception
			}
		}).forEach(System.out::println);

	}
}
