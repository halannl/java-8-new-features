package functionalinterfaces;

public class FunctionalInterfacesExplanation {

	/**
		A Functional Interface is an interface that has only one abstract method!
		No matter how many default methods or static methods they have,
		if it has only one abstract method, it is a Functional Interface.
		Let's see an example:
	**/
	@FunctionalInterface // This is the new annotation, that represents a Functional Interface.
						 // It is not required, but with it, compiler can help you build write a right Functional Interface.
	interface FunctionalInterfaceExample {

		/**
		 * Single abstract method, that represents the method a lambda expression should implement.
		 */
		void method1();

		// Note that if you uncomment the line below, then the compiler will be sad because it's annotated with @FunctionalInterface.
		// void method2();
		
		/**
		 * Now it is possible to create default methods inside interfaces.
		 * They are methods that can be overridden in another interface or implementation class.
		 * Note that even with this method, compiler is still happy because there is only one abstract method.
		 */
		default void method3() { }
		
		/**
		 * Now it is also possible to create static methods inside interfaces.
		 * They help developers to create utilities methods that are specific for your interface.
		 * And it also doesn't matter to keep your interface a Functional Interface.
		 */
		static void method4() { }
		
	}
	
	/**
	 * An interface that extends the Functional Interface, but is not one.
	 */
	interface InterfaceExample2 extends FunctionalInterfaceExample {
		
		/**
		 * The first interface is Functional, but this isn't, than it can have another (because father has one)
		 * But it is not a Functional Interface! Note that if you annotate it with @FunctionalInterface, compiler will become sad.
		 */
		void method2();
		
		/**
		 * Here we can see how even in a non Functional interface, we can override both default and static methods.
		 */
		default void method3() {}
		static void method4() {}
	}
	
	/**
	 * Now an example of using our fresh Functional Interface. 
	 */
	public static void main(String[] args) {
		int i1 = 0;
		// Here we can see that if no arguments are required for the method implemented, you can just write "()".
		FunctionalInterfaceExample f = () -> {
			// i1 = 2;
			// Above is an important detail, you cannot edit external variables inside lambda expression
			// But you can create others like this:
			int i2 = 2;
			System.out.printf("Lambda execution with %d and %d", i1, i2);
		};
		f.method1();
	}
}
