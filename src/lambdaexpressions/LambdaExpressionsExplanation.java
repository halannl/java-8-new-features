package lambdaexpressions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaExpressionsExplanation {

	/**
	 * This is a simple method, that squares an integer, made in the classic old
	 * versions
	 */
	public Integer squareInt(Integer i) {
		return i * i;
	}

	/**
		The above can now be written as lambda expression this way:
	  
	  	i -> i*i;
	  
	  	You can simplify the whole method declaration with simply the parameter name,
	  	and avoid parenthesis in case of a single parameter. 
	  	And the return statement can be abstracted by the JVM according to the context. 
	  	In case of one single statement in the method body, you can avoid using curly brackets.
	  	Now let's build a more complex method to clarify:
	 **/
	public static Integer multiply(Integer i1, Integer i2) {
		System.out.printf("Multiplying %d and %d", i1, i2);
		return i1 * i2;
	}

	/**
		Note that now we have 2 parameters and more than one statement in method's
		body, then now the lambda is:
	  
		(i1, i2) -> { 
	  					System.out.printf("Multiplying %d and %d", i1, i2); 
	  					return i1*i2; 
	  				}
	  
	 	Now, we have to do it inside curly brackets, add return key word and declare both 
	 	parameters into parenthesis, but JVM still knows, according to the context.
	 	But, how to use these lambda expressions?
	 	R: With Functional Interfaces!
	 	Let's see:
	 **/
	public static void main(String[] args) {
		Function<Integer, Integer> f1 = i -> i*i; // lambda expression
		System.out.println("Applying Function: "+ f1.apply(5));
		
		BiFunction<Integer, Integer, Integer> f2 = (i1, i2) -> { 
				System.out.printf("Multiplying %d and %d \n", i1, i2); 
				return i1*i2; 
			}; // lambda expression
		System.out.println("Applying BiFunction: " + f2.apply(5, 5));
	}
	
	/**
		Then lambda expressions are used to implement a Functional Interface abstract method.
	 	The Functional Interfaces will be covered in another package.
	 	But you can see some Predefined Functional Interfaces in this link:
	 	https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
	**/

}
