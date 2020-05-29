package Corejava;

public class StringPoolCompare {

	public static void main(String[] args) {
		String a = "Ashish";
		if(a.hashCode() == "Ashish".hashCode()) {
			System.out.println("In if");
		}
		else
		{
			System.out.println("In else");
		}

	}

}
