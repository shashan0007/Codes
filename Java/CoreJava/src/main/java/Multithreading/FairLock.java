package Multithreading;

import java.util.ArrayList;
import java.util.List;

public class FairLock {

	public static void main(String[] args) {
		Thread t1[] = new Thread[5];
		
		/*********** Creating Threads *********/
		
		for(int i = 0; i < 5; i++) {
			t1[i] = new Thread(FairT1.instance, "Fair_Thread"+(i+1));
		}
		
		/********* Starting Threads **********/
		
		for( int i = 0; i < 5; i++ ) {
			t1[i].start();
		}	
	}
}
class FairT1 implements Runnable {
	
	static FairSharedElement se = FairSharedElement.element;
	static FairT1 instance = new FairT1();
	public FairT1(){}

	@Override
	public void run() {
		try {
			System.out.println("This hashcode " + this.hashCode());
			this.executeMethod1();
			try {
				Thread.sleep(4L * 1000L);
			}
			catch(InterruptedException ie){
				System.err.println("Error occured inside thread sleep method for -> " + Thread.currentThread().getName());
				ie.printStackTrace();
			}
			System.out.println("Hi I have reached here after acquiring lock and now I can do anything.  ");
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
			
			System.out.println("Error :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*************** This method when called can lead to starvation due to wait before synchronized ****************/
	
	public synchronized void executeMethod() {
		System.out.println("Thread" + Thread.currentThread().getName() + "  Value in Shared Element: -> " + se.value);
		se.execute();
	}
	
	public void executeMethod1() throws InterruptedException {
		QueueObject queueObject = new QueueObject();
		boolean isLockedForThisThread = true;
		synchronized(this){
			System.out.println(" Adding thread " + Thread.currentThread().getName() + " to List of shared monitor ");
			se.threadList.add(queueObject);
			System.out.println("Size of array list after adding queueObject " + queueObject.hashCode() + " is " + se.threadList.size()); 
		}
		while(isLockedForThisThread){
			synchronized(this){
						isLockedForThisThread = se.isLocked || queueObject != se.threadList.get(0);
							if(!isLockedForThisThread){
								se.isLocked = true;
								se.blockingThread = Thread.currentThread();
								se.threadList.remove(queueObject);
								return;
							}
					}
					System.out.println("Thread going to wait: " + Thread.currentThread().getName());
					try {
						queueObject.doWait();
						System.out.println("Reached here after calling wait");
					} catch(InterruptedException ie1){
						synchronized (this) {
							se.threadList.remove(queueObject);
							throw ie1;
						}	
					}
			}
		}
	public void unlock() {
		if(se.blockingThread != Thread.currentThread()){
		      throw new IllegalMonitorStateException(
		        "Calling thread has not locked this lock");
		}
		System.out.println(" Thread going to notify: " + Thread.currentThread().getName());
			System.out.println(" Reached inside notify of :" + Thread.currentThread().getName());
			se.isLocked = false;
			se.blockingThread = null;
			se.threadList.get(0).doNotify();
		}
	}

class FairSharedElement {
	public int value = 0;
	public Thread blockingThread;
	public List<QueueObject> threadList;
	public boolean isLocked = false;
	public static FairSharedElement element = new FairSharedElement(8);
	
	private FairSharedElement(int val) {
		this.value = val;
		this.threadList = new ArrayList<QueueObject>();
		this.blockingThread = null;
	}
	
	public synchronized void execute(){
		System.out.println("Thread : -> " + Thread.currentThread().getName());
	}
}

class QueueObject {
	public boolean isNotified = false;
	
	public void doWait() throws InterruptedException {
		while(!isNotified) {
			try {
				System.out.println("Thread coming in wait condition with object " +Thread.currentThread().getName() + "  " + this.hashCode());
				synchronized (this) {
					wait();
				}
				this.isNotified = false;
				System.out.println("Thread waking up:" + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	public void doNotify() {
		System.out.println("Reached inside notify to notify Thread and object " + Thread.currentThread().getName() + "  " + this.hashCode());
		this.isNotified = true;
		this.notify();
	}
}