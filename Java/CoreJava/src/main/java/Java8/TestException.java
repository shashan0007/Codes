package Java8;
import java.io.IOException;
public class TestException {
	
	// Java program to illustrate exception propagation 
	// in checked exceptions and it can be propagated 
	// by throws keyword ONLY  

		// exception propagated to n() 
		void m() throws IOException 
		{ 
			// checked exception occurred 
			throw new IOException("device error"); 
		} 

		// exception propagated to p() 
		void n() throws IOException 
		{ 
			m(); 
		} 
		void p() 
		{ 
			try { 

				// exception handled 
				n(); 
			} 
			catch (Exception e) { 
				System.out.println("exception handled"); 
				e.printStackTrace();
			} 
		} 

		public static void main(String args[]) 
		{ 
			TestException obj = new TestException(); 
			obj.p(); 
			System.out.println("normal flow..."); 
		} 
	} 

