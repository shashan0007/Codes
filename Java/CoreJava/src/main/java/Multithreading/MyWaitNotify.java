package Multithreading;

public class MyWaitNotify {

	public static void main(String[] args) {
		Monitor m = new Monitor();
		Thread t1 = new Thread(new MyWaitNotifyThread(m),"Thread-0");
		Thread t2 = new Thread(new MyWaitNotifyThread(m),"Thread-1");
		
		t1.start();
		t2.start();
	}

}
class Monitor {
	public void print() {
		System.out.println("Monitor class");
	}
}

class MyWaitNotifyThread implements Runnable {
	Monitor sharedMonitor;
	static boolean setFlag = false;
	
	MyWaitNotifyThread(Monitor mon){
		sharedMonitor = mon;
	}

	@Override
	public void run() {
		if((Thread.currentThread().getName()).trim().equals("Thread-0")){
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (sharedMonitor) {
				System.out.println("Inside Thread-0 sync block");
				if(!setFlag){
				try {
					sharedMonitor.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} }
			}
		}
		else {
			synchronized (sharedMonitor) {
				System.out.println("Inside Thread-1 sync block");
				setFlag = true;
				sharedMonitor.notify();
			}
		}
	}
}
