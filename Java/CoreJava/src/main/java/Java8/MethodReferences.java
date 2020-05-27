/*A method reference is a simplified form (or short-hand) of a lambda expression. It specifies the class name or the instance name followed by the method name. Instead of writing the lambda expression with all the details such as parameter and return type, a method reference lets you create a lambda expression from an existing method implementation.
Method Reference Syntax: <class or instance name>::<methodName>
Method Reference Example
Integer::parseInt is a method reference with the following charecteristics –

It is equivalent to the lambda –
(String str, Integer integer)->Integer.parseInt(str)
It can can be assigned to a functional interface Function<T ,R> like this –
  Function<String,integer> intParser=Integer::parseInt
Above assignment is equivalent to the assignment of lambda expression of parseInt() –
Function<String,Integer> intParser =
(String str,Integer integer)->Integer.parseInt(str)

Type 1: Reference to a static method – If we intend to use a static method of a class then instead of writing the lengthier lambda expresion we can just refer to the method via method references.
Types of Method References
Lambda Syntax: (arguments) -> <ClassName>.<staticMethodName>(arguments);
Equivalent Method Reference: <ClassName> :: <staticMethodName>*/

package Java8;

import java.util.function.Function;

public class MethodReferences {

	public static void main(String[] args) {
		Function<String, Double> dblConverter = Double::parseDouble;
		Function<String, Double> dblConverterLambda = (String s) -> Double.parseDouble(s);
		System.out.println("With Method Reference: " + dblConverter.apply("12.12"));
		System.out.println("With lambda expression: " + dblConverterLambda.apply("123"));
	}
}
