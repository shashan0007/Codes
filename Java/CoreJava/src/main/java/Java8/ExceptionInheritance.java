package Java8;
import java.io.IOException;
import java.util.Arrays;

public class ExceptionInheritance {
	
	public void sum() throws IOException
	{
		System.out.println("Hi I !");
	}
	
	public static void main(String args[]) throws IOException  {
		ExceptionInheritance ei = new child();
		ei.sum();
		System.out.println(Arrays.toString(ei.getClass().getDeclaredMethods()));
	}
}

class child extends ExceptionInheritance {
	@Override
	public void sum() throws IOException{
		super.sum();
		System.out.println("Hi !");
	}
}

