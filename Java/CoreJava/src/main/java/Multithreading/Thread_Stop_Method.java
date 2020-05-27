package Multithreading;

public class Thread_Stop_Method {
	
	public static void main(String args[]){	
		MyRunnable myRunnable = new MyRunnable();
		Thread t = new Thread(myRunnable, "My Runnable Thread");
		t.start();
		try {
			System.out.println("Sleeping main thread");
			Thread.sleep(15L * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Sending stop signal");
		myRunnable.stop();
	}
}

class MyRunnable implements Runnable {

	private boolean doStop = false;
	
	public void stop() {
		System.out.println("Stopping signal received");
		this.doStop = true;
	}
	
	@Override
	public void run() {
		while(doStop == false){
			try {
				System.out.println("Going to Sleep");
				Thread.sleep(3L * 1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}	
}