package optional_class_example;

public class Nullpointer_example {

	public static void main(String[] args) {
	
		String[] str =new String [10];
		
		System.out.println("String print of 5th"+str[5]);
		
		String lowerCase = str[5].toLowerCase();
		System.out.println(lowerCase);

	}

}

/*
 * NullPointerException is a RuntimeException. In Java, a special null value can
 * be assigned to an object reference. NullPointerException is thrown when a
 * program attempts to use an object reference that has the null value.
 */