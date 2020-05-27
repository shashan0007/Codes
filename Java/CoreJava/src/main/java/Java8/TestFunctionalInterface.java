/*A functional interface, introduced in Java 8, is an interface which has only a single abstract method. Conversely, 
if you have any interface which has only a single abstract method, then that will effectively be a functional interface. 
This interface can then be used anywhere where a functional interface is eligible to be used.

One of the most important uses of Functional Interfaces is that implementations of their abstract method can be passed around 
as lambda expressions. By virtue of their ability to pass around functionality(i.e. behavior), 
functional interfaces primarily enable behavior parameterization.

@FunctionalInterface is an informative annotation, i.e. it is not mandatory to use this annotation for classifying the given 
interface as a valid functional interface. Rather, if one uses this annotation, then the compiler ensures that the interface 
is not inadvertently changed in such a way that it no longer remains a functional interface
*/
package Java8;

@FunctionalInterface
public interface TestFunctionalInterface {
	public void print(String param);
}
