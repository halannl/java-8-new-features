package functionalinterfaces;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredefinedFunctionalInterfaces {

	/**
	 * There are many predefined Functional Interfaces, but this is going to cover only the 4 most important
	 * They are:
	 * 	- Predicate
	 * 	- Function
	 * 	- Consumer
	 * 	- Supplier
	 *  If you want to see about the others, you can check the java.util.function package API in this link:
	 *  https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
	 */
	public static void mainExamplesMethod() {
		
		// Predicate is the simplest. It receives only one argument and always returns a boolean value
		// In this example, we are creating and testing a Predicate that check if a number is greater than 10
		Predicate<Integer> p = i -> i > 10; // Receives Integer
		System.out.println("Param greater than 10? R: " + p.test(11)); // test() is the abstract method of Predicate
		
		// Function is the one that	receive an argument and execute a function on it, returning the result of this function
		// In this example, we are going to square the parameterized Integer
		Function<Integer, Integer> f = i -> i*i; // Receives Integer and returns Integer
		System.out.println("Squared result: " + f.apply(5)); // apply() is the abstract method of Function
		
		// Consumer just receive an argument and processes it don't returning anything
		// In this case, receiving any String and printing it
		Consumer<String> c = s -> System.out.println(s);
		c.accept("String to be consumed"); // accept() is the abstract method of Consumer
		
		// Supplier is the Functional Interface that just return some value of determined source
		// In this example, the Consumer will return a randomized Integer value between 1 and 4
		Supplier<Integer> s = () -> new Random().nextInt(4) + 1; // Will consume an Integer
		System.out.println("Random value between 1 and 4: " + s.get()); // get() is the abstract method of Supplier
	}
	
	/**
	 * In case of Predicate, there is also possible to execute operations between Predicates
	 * You can find more methods in the API, I'll show some most important ones
	 */
	public static void predicateOperationsExample() {
		
		// First, let's create an array to execute the Predicates
		int[] x = {0, 5, 10, 15, 20, 25, 30};
		
		// For that, let's create some Predicates
		Predicate<Integer> p1 = i -> i > 10; // one that checks if number is greater than 10
		Predicate<Integer> p2 = i -> i % 2 == 0; // other to check if the number is even
		System.out.println("The numbers greater than 10 are:");
		m1(p1, x);
		System.out.println("The even numbers are:");
		m1(p2, x);
		System.out.println("The numbers not greater than 10 are:");
		m1(p1.negate(), x); // negate() negate the condition of the Predicate
		System.out.println("The numbers greater than 10 and even re:");
		m1(p1.and(p2), x); // and() check both Predicates like && operator
		System.out.println("The numbers greater than 10 OR even");
		m1(p1.or(p2), x);  // or() check both Predicates like || operator
		
		// Note that and(), negate() and or() are default methods inside Predicate functional interface
	}
	
	/**
	 * Utility method to print the predicate's true condition
	 */
	public static void m1(Predicate<Integer> p, int[] x) {
		for (int x1 : x) {
			if (p.test(x1))
				System.out.println(x1);
		}
	}
	
	/**
	 * Execution of examples
	 */
	public static void main(String[] args) {
		mainExamplesMethod();
		predicateOperationsExample();
	}
}
