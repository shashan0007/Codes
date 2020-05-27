package Multithreading;

public class ThreadDeadlock {
	static MonitorObject m1;
	static MonitorObject m2;
	
	public ThreadDeadlock(){}
	
	public static void main(String args[]){
		ThreadExample t1 = new ThreadExample();
		ThreadExample t2 = new ThreadExample();
		
		m1 = new MonitorObject("Monitor 1");
		m2 = new MonitorObject("Monitor 2");
		
		t1.start();
		t2.start();
	}
}
class ThreadExample extends Thread {
	@Override
	public void run(){
		System.out.println("Inside Thread:  "+ Thread.currentThread().getName());
		if((Thread.currentThread().getName()).trim().equals("Thread-0")){
			synchronized(ThreadDeadlock.m1) {
				System.out.println("Holding lock on m1 : " + Thread.holdsLock(ThreadDeadlock.m1));
					try {
						ThreadDeadlock.m1.wait();
						ThreadDeadlock.m2.print();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
		else{
			synchronized(ThreadDeadlock.m2) {
				System.out.println("Holding lock on m2  : " + Thread.holdsLock(ThreadDeadlock.m2));
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					ThreadDeadlock.m2.wait();
					ThreadDeadlock.m1.print();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}

class MonitorObject {
	private String description;
	
	public MonitorObject(String desc){
		this.description = desc;
	}
	
	public void print(){
		System.out.println("Print method called from "+ this.description);
	}
}

