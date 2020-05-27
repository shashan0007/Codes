package Multithreading;

public class StaticSynhronization {
	
	Integer a = new Integer(99);
	
	protected static void execute(){
		System.out.println("Hi ! from thread :" + Thread.currentThread().getName());
	}
}

class MyRunnable1 implements Runnable {
	
	public StaticSynhronization instance;
	public static Integer integer = new Integer(70);
	public MyRunnable1(StaticSynhronization a) {
		instance = a;
	}

	@Override
	public void run() {
		run1();
	}
	
	public static synchronized void run1(){
		//instance = new StaticSynhronization();
		integer = new Integer(10);
		StaticSynhronization.execute();
	}
	
}
class C {
	static StaticSynhronization sharedInstance = new StaticSynhronization();
	public static void main(String args[]){
		Thread t1 = new Thread(new MyRunnable1(sharedInstance), "Thread 1");
		Thread t2 = new Thread(new MyRunnable1(sharedInstance), "Thread 2");
		
		t1.start();
		t2.start();
		
	}
}
