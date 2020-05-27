package Multithreading;

public class CustomLock {

	public static void main(String[] args) {
		Thread t1[] = new Thread[5];
		
		/*********** Creating Threads *********/
		
		for(int i = 0; i < 5; i++) {
			t1[i] = new Thread(new T1(), "T1"+(i+1));
		}
		
		/********* Starting Threads **********/
		
		for(int i = 0; i < 5; i++ ) {
			t1[i].start();
		}	
	}
}
class T1 implements Runnable {
	
	SharedElement se = SharedElement.element;

	@Override
	public void run() {
		try {
			this.executeMethod1();
			try {
				Thread.sleep(10L * 1000L);
			}
			catch(InterruptedException ie){
				System.err.println("Error occured inside thread sleep method for -> " +Thread.currentThread().getName());
				ie.printStackTrace();
			}
			System.out.println("Hi I have reached here after acquiring lock and now I can do anything");
			System.out.print(" My Name is: " + Thread.currentThread().getName() + " . I will sleep for 2 seconds");
			try {
				Thread.sleep(2L * 1000L);
			}
			catch(InterruptedException ie){
				System.err.println("Error occured inside thread sleep method 2nd for -> " +Thread.currentThread().getName());
				ie.printStackTrace();
			}
			this.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*************** This method when called can lead to starvation due to wait before synchronized ****************/
	
	public synchronized void executeMethod() {
		System.out.println("Thread" + Thread.currentThread().getName() + "  Value in Shared Element: -> " + se.value);
		se.execute();
	}
	
	public void executeMethod1() throws InterruptedException {
		synchronized(se){
			while(se.isLocked) {
			System.out.println("Thread going to wait: " + Thread.currentThread().getName());
			se.wait();
			}
			System.out.println("Thread going to set isLocked: " + Thread.currentThread().getName());
			se.isLocked = true;
		}
	}
	public void unlock() {
		System.out.println("Thread going to notify: " + Thread.currentThread().getName());
		synchronized(se){
			se.isLocked = false;
			se.notify();
		}
	}
}

class SharedElement {
	
	public int value = 0;
	public boolean isLocked = false;
	public static SharedElement element = new SharedElement(8);
	
	private SharedElement(int val) {
		this.value = val;
	}
	
	public synchronized void execute(){
		System.out.println("Thread : -> " + Thread.currentThread().getName());
	}
}
