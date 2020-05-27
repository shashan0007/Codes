package Multithreading;

public class InheritableThreadLocal {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new MyThread(),"Thread 1");
		Thread thread2 = new Thread(new MyThread(),"Thread 2");
		thread1.start();
		thread2.start();
	}
}

class MyThread implements Runnable {
	
	private static ThreadLocal<String> a = new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return "Initial Value of static variable";
		}
	};
	
	private java.lang.InheritableThreadLocal<Integer> itl = new  java.lang.InheritableThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 10;
		}
	};

	@Override
	public void run() {
		if((Thread.currentThread().getName()).equals("Thread 1")){
			Thread childThread = new Thread(new ChildThread(itl),"Child Thread of Thread 1");
			Thread childThread2 = new Thread(childThread);
			childThread.start();
			childThread2.start();
			System.out.println("Thread 1 : " + a.get().hashCode() + "itl value   : " + itl.get());
			try {
				Thread.sleep(4L * 1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread 1 : " + a.get().hashCode() + " value : " + a.get()+ "  itl value   : " + itl.get());
			try {
				Thread.sleep(4L * 1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a.set("I am Thread 1 again");
			System.out.println("Thread 1 : " + a.get().hashCode() + " value : " + a.get() + "  itl value   : " + itl.get());
		}
		else {
			System.out.println("Thread 2 : " + a.get().hashCode() + " value : " + a.get());
			a.set("I am Thread 2 setting by thread 2");
			System.out.println("Thread 2 : " + a.get().hashCode() + " value " + a.get());
		}	
	}
}

class ChildThread implements Runnable {
	
	private java.lang.InheritableThreadLocal<Integer> itlChild;
	
	public ChildThread(java.lang.InheritableThreadLocal<Integer> val){
		itlChild = val;
	}
	
	@Override
	public void run() {
		System.out.println("Inside Child Thread " + Thread.currentThread().getName() + " itl value  "+ itlChild.get() );
		if((Thread.currentThread().getName()).trim().equals("Thread-0")){
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Inside Child Thread " + Thread.currentThread().getName() + " itl value  "+ itlChild.get() );
			itlChild.set(99);
			System.out.println("Inside Child Thread  : "+ Thread.currentThread().getName() + " itl value after setting  "+ itlChild.get());
		}
		else {
		System.out.println("Inside Child Thread  : "+ Thread.currentThread().getName() + " itl value before setting  "+ itlChild.get());
		itlChild.set(98);
		System.out.println("Inside Child Thread  : "+ Thread.currentThread().getName() + " itl value after setting  "+ itlChild.get());
	} }
}

