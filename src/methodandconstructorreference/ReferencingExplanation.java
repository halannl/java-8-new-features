package methodandconstructorreference;

import java.util.function.Consumer;

public class ReferencingExplanation {

	/**
	 * Now in Java 1.8 is possible to reference a method or constructor to replace a lambda expression
	 * by using the :: (double colon) operator.
	 * Let's show how you can use method reference.
	 * First, we will create a method to be referenced:
	 */
	public static void print(String s) {
		System.out.println(s);
	}

	/**
	 * Now testing the method reference in a Consumer functional interface
	 */
	public static void testMethodReference() {
		
		// The only requirement is that the method must have the same arguments types and number
		// In this case, as the referenced method is static, you can make the reference this way:
		Consumer<String> c = ReferencingExplanation::print; // Static reference

		// But you also can reference using instance reference, removing static modifier of methods:
		// Consumer<String> c = this::print; // Instance reference
		
		c.accept("String printed in referenced method!");
	}
	
	/**
	 * Now we will test the constructor reference
	 * For that we will create some utility class
	 * Static, according to our context
	 */
	static class Sample {
		
		private String s;

		// A constructor receiving a String, setting it in the instance and printing
		Sample(String s) {
			this.s = s;
			System.out.println("Constructor executed: " + this.s);
		}
	}

	/**
	 * An interface that has our abstract method that receive a String and return Sample class
	 */
	interface Interf {
		public Sample get(String s);
	}
	
	public static void testConstructorReference() {
		
		// The way using normal lambda expression is:
		Interf f = s -> new Sample(s);
		f.get("From lambda expression");
		
		// And the way using the constructor reference:
		Interf f1 = Sample :: new; // Static reference
		f1.get("From constructor reference"); 
	}

	/**
	 * Execution of examples
	 */
	public static void main(String[] args) {
		testMethodReference();
		testConstructorReference();
	}
}
