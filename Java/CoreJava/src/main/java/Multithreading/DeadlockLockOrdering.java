package Multithreading;

public class DeadlockLockOrdering {
	
	public static final String resourceA = "Ashish";
	public static final String resourceB = "Java";
	public static final String resourceC = "Champion";

	public static void main(String[] args) {
		Thread t1,t2,t3;
		t1 = new Thread(new ThreadA());
		t1.setPriority(5);
		t2 = new Thread(new ThreadB());
		t3 = new Thread(new ThreadC());
		t2.setPriority(10);
		t3.setPriority(1);
		
		t1.start();
		System.out.println("Thread A started");
		t2.start();
		System.out.println("Thread B started");
		t3.start();
		System.out.println("Thread C started");
	}

}

class ThreadA implements Runnable {

	@Override
	public void run() {
		synchronized(DeadlockLockOrdering.resourceA){
			System.out.println("Inside Thread A: holding lock on resource A ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceA));
			System.out.println("Inside Thread A: holding lock on resource B ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceB));
			System.out.println("Inside Thread A: holding lock on resource C ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceC));
			
			if(Thread.holdsLock(DeadlockLockOrdering.resourceA)){
				System.out.println("Inside A, trying to lock B");
				synchronized(DeadlockLockOrdering.resourceB){
					System.out.println("Inside Thread A lock synch block B: holding lock on resource A ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceA));
					System.out.println("Inside Thread A lock synch block B: holding lock on resource B ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceB));
					System.out.println("Inside Thread A lock synch block B: holding lock on resource C ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceC));
					if(Thread.holdsLock(DeadlockLockOrdering.resourceA) && Thread.holdsLock(DeadlockLockOrdering.resourceB)){
						System.out.println("Inside A, trying to lock C");
						synchronized (DeadlockLockOrdering.resourceC) {
							System.out.println("Inside Thread A lock synch block C: holding lock on resource A ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceA));
							System.out.println("Inside Thread A lock synch block C: holding lock on resource B ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceB));
							System.out.println("Inside Thread A lock synch block C: holding lock on resource C ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceC));
						}
					}
				}
			}
		}
	}
}

class ThreadB implements Runnable {

	@Override
	public void run() {
		synchronized(DeadlockLockOrdering.resourceB){
			System.out.println("Inside Thread B: holding lock on resource A ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceA));
			System.out.println("Inside Thread B: holding lock on resource B ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceB));
			System.out.println("Inside Thread B: holding lock on resource C ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceC));
			
			if(Thread.holdsLock(DeadlockLockOrdering.resourceB)){
				System.out.println("Inside B, trying to lock C");
				synchronized(DeadlockLockOrdering.resourceC){
					System.out.println("Inside Thread B lock synch block C: holding lock on resource A ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceA));
					System.out.println("Inside Thread B lock synch block C: holding lock on resource B ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceB));
					System.out.println("Inside Thread B lock synch block C: holding lock on resource C ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceC));
					if(Thread.holdsLock(DeadlockLockOrdering.resourceB) && Thread.holdsLock(DeadlockLockOrdering.resourceC)){
						System.out.println("Inside B, trying to lock A");
						synchronized (DeadlockLockOrdering.resourceA) {
							System.out.println("Inside Thread B lock synch block A: holding lock on resource A ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceA));
							System.out.println("Inside Thread B lock synch block A: holding lock on resource B ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceB));
							System.out.println("Inside Thread B lock synch block A: holding lock on resource C ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceC));
						}
					}
				}
			}
		}
	}
}

class ThreadC implements Runnable {

	@Override
	public void run() {
		synchronized(DeadlockLockOrdering.resourceC){
			System.out.println("Inside Thread C: holding lock on resource A ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceA));
			System.out.println("Inside Thread C: holding lock on resource B ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceB));
			System.out.println("Inside Thread C: holding lock on resource C ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceC));
			
			if(Thread.holdsLock(DeadlockLockOrdering.resourceC)){
				System.out.println("Inside C, trying to lock A");
				synchronized(DeadlockLockOrdering.resourceA){
					System.out.println("Inside Thread C lock synch block A: holding lock on resource A ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceA));
					System.out.println("Inside Thread C lock synch block A: holding lock on resource B ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceB));
					System.out.println("Inside Thread C lock synch block A: holding lock on resource C ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceC));
					if(Thread.holdsLock(DeadlockLockOrdering.resourceC) && Thread.holdsLock(DeadlockLockOrdering.resourceA)){
						System.out.println("Inside C, trying to lock B");
						synchronized (DeadlockLockOrdering.resourceB) {
							System.out.println("Inside Thread C lock synch block B: holding lock on resource A ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceA));
							System.out.println("Inside Thread C lock synch block B: holding lock on resource B ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceB));
							System.out.println("Inside Thread C lock synch block B: holding lock on resource C ? -> " + Thread.holdsLock(DeadlockLockOrdering.resourceC));
						}
					}
				}
			}
		}
	}
}




