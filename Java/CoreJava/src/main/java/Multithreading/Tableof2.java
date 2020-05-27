package Multithreading;

public class Tableof2 {

	public static void main(String[] args) {
		Thread t1 = new TwoThreads("Thread1");
		Thread t2 = new TwoThreads("Thread2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class TwoThreads extends Thread {
	private static Integer incCount = 1;
	private static String command = "STOP";
	public TwoThreads() {
		super();
	}
	
	public TwoThreads(String id) {
		super(id);
	}
	
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("Thread1")) {
			synchronized (incCount) {
				while(true) {
					if(incCount == 10) break;
					if(command.equalsIgnoreCase("STOP")) {
						System.out.println("2 * " + incCount + " = " + 2 * incCount);
						incCount++;
						command = "START";
						//incCount.notifyAll();
					}
					else {
						try {
							System.out.println("Thread 1 going to wait");
							incCount.wait();
						} catch (InterruptedException e) {
						// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}	
				}
			}
		}
		if(Thread.currentThread().getName().equals("Thread2")) {
			synchronized (incCount) {
				while(true) {
					if(incCount == 10) break;
					if(command.equalsIgnoreCase("START")) {
						System.out.println("2 * " + incCount + " = " + 2 * incCount);
						incCount++;
						command = "STOP";
					}
					else {
						System.out.println("Thread 2 going to wait");
						incCount.notify();
					}
				}
			}
		}
	}
}	
