/*
 * Important points to understand regarding the lambda expression defined above-
 * The element to the left of the arrow(->) are the parameters of the lambda. In this case the input parameter is defined as- String param.
 * To the right of the arrow(->) we have the body of the lambda. Body is where the actual processing within a lambda happens. I.e. the logic of the lambda goes here. The above lambda has a simple logic. It prints the param passed to it appended to a general string value and does not return anything, i.e. return type is void (more on returning values later).
 * Parameter – String param, and return type – void, both closely match the signature of singleMethod() in FirstInterface defined above. This matching of signatures allows us to assign an instance of the lambda defined above to an instance of the interface FirstInterface as shown below –
 * FirstInterface instance = (String param) -> {System.out.println("My lambda says "+ param);};
 * We can now pass this instance as a parameter wherever FirstInterface is expected.
 * Lambda syntax contains 2 variants of return types. This types are based on the contents in lambda following the arrow(->) sign –
 * Variant 1.(parameters) -> expression– In this variant the return type of the lambda expression will be same as the resultant type of the expression
 * Variant 2.(parameters) -> {statements;} – In this variant, there will be no return type(or void return type) unless the statements inside the curly braces explicitly return something at the end. In that case the return type will be same as the type of the variable returned.
 */

package Java8;

public class LamndaBasicExample {
	
	public static void main(String[] args) {
		LamndaBasicExample instance = new LamndaBasicExample();
		instance.print((String param)->{System.out.println("Printing lambda: " + param);});
	}
	
	public void print(TestFunctionalInterface instance) {
		instance.print("Ashish");
	}
}
