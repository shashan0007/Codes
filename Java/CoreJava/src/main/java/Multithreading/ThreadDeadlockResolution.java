package Multithreading;

public class ThreadDeadlockResolution {

	protected static MonitorObject1 m1;
	public ThreadDeadlockResolution(){}
	
	public static void main(String args[]){
		ThreadExample1 t1 = new ThreadExample1();
		ThreadExample1 t2 = new ThreadExample1();
		
		m1 = new MonitorObject1("Monitor 1");
		t1.start();
		System.out.println("Thread-0 started");
		t2.start();
		System.out.println("Thread-1 started");
	}
}
class ThreadExample1 extends Thread {
	@Override
	public void run(){
		System.out.println("Inside Thread:  "+ Thread.currentThread().getName());
		if((Thread.currentThread().getName()).trim().equals("Thread-0")){
			synchronized(ThreadDeadlockResolution.m1) {
				System.out.println("Thread-0 -> Holding lock on m1 : " + Thread.holdsLock(ThreadDeadlockResolution.m1));
					try {
						ThreadDeadlockResolution.m1.wait();
						ThreadDeadlockResolution.m1.print();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
		else{
			synchronized(ThreadDeadlockResolution.m1) {
				System.out.println("Thread-1 -> Holding lock on m1  : " + Thread.holdsLock(ThreadDeadlockResolution.m1));
				
				ThreadDeadlockResolution.m1.notify();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				
				ThreadDeadlockResolution.m1.print();
			}
		}
	}
}

class MonitorObject1 {
	private String description;
	
	public MonitorObject1(String desc){
		this.description = desc;
	}
	
	public void print(){
		System.out.println("Print method called from "+ this.description);
	}
}