package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiExplanation {

	/**
	 * The new Stream API is not about file transferring like java.io does
	 * It is a different one contained in the package java.util.stream
	 * And it is about Collections!
	 * 
	 * The new Stream API was created to help developers manage Collections
	 * in a easier, shorter and cleaner way.
	 * 
	 * Let's create a sample Collection to use in the examples 
	 */
	public static ArrayList<Integer> getCollection() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0 ; i  <= 10 ; i++) {
			al.add(i);
		}
		return al;
	}
	
	/**
	 * Filtering:
	 * We can configure a filter to filter elements from the collection based on some boolean condition by
	 * using filter() method of Stream interface.
	 */
	public static void filterExample() {
		List<Integer> l = getCollection();
		Stream<Integer> s = l.stream(); // New method inside Collection interface
		l = s.filter(i -> i % 2 == 0) // Stream.filter() receives a Predicate as argument, then we can replace it by lambda expression
				.collect(Collectors.toList()); // Method collect to put the elements from the Stream into a Collection
		System.out.println("Even elements " + l); // Prints even numbers
	}
	
	/**
	 * Mapping:
	 * If we want to create a separate new object, for every object present in the collection based on our
	 * requirement then we should go for map() method of Stream interface.
	 */
	public static void mapExample() {
		List<Integer> l = getCollection();
		Stream<Integer> s = l.stream();
		
		// In this case, we will replace the list with your elements squared
		l = s.map(i -> i*i) // Stream.map() receives a Function as argument, then we can replace it by lambda expression
				.collect(Collectors.toList());
		System.out.println("Squared elements " + l); // Prints squared numbers
	}
	
	/**
	 * Utilities:
	 * Now let's talk about some utilities methods Stream API has
	 * Following the examples:
	 */
	public static void utilitiesExample() {
		List<Integer> l = getCollection();
		
		// The first is count() that counts elements in Stream
		System.out.println(l.stream().count() + " elements in the Stream");
		
		// The second is sorted() that can sort the elements of the Stream by natural order or a Comparator
		System.out.println("Ordered List " + l.stream().sorted().collect(Collectors.toList())); // In this case, same order
		// But you can provide a Comparator, that is also a Functional Interface because has only compareTo() abstract method
		System.out.println("Inverse order " + l.stream().sorted((s1,s2) -> -s1.compareTo(s2)) // Replacing Comparator with a lambda expression
				.collect(Collectors.toList())); // Prints the inverse order according to customized Comparator
		
		// min() and max() methods, that also receives Comparator
		System.out.println("Min " + l.stream().min((s1,s2) -> s1.compareTo(s2)).get()); // Min in normal order
		System.out.println("Max inverse " + l.stream().max((s1,s2) -> -s1.compareTo(s2)).get()); // Max in inverse order
		
		// Note that both max() and min() methods returns Optional class, that avoids nullPointerException. Check on:
		// https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
		
		// toArray() makes possible to convert the stream into an array
		Integer[] intArray = l.stream().toArray(Integer[]::new); // toArray receives an IntFunction, that can be replaced by lambda expression
		System.out.println("An array of " + intArray.length + " elements.");
		
		// Stream.of() is the static method provides a Stream of arrays or group of any elements
		System.out.println("A Stream of " + Stream.of(1,2,3).count() + " elements from a group of values");
		System.out.println("A Stream of " + Stream.of(intArray).count() + " elements from an array");
		
		// And the last one that is the forEach() method, that receives a Consumer functional interface
		Stream.of(intArray).forEach(System.out::print); // Another example of using method reference
		// System.out.print receives one argument, just like Consumer's abstract method. Then it can be referenced in forEach() method
	}

	/**
	 * Execution of examples
	 */
	public static void main(String[] args) {
		filterExample();
		mapExample();
		utilitiesExample();
	}
}
