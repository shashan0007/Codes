package Multithreading;
import java.util.Arrays;
import java.util.Map;

class ThreadExecute implements Runnable{
	private static ThreadExecute t = new ThreadExecute();
	
	@Override
	public void run() {
		System.out.println("Inside Run of "+Thread.currentThread().getName());
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t = createThread();
		synchronized(t){
			try {
				t.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			executePrint(t);
		}
		
	}
	public synchronized ThreadExecute createThread(){
		System.out.println("Inside object creation  "+Thread.currentThread().getName());
		/*try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		return t;
	}
	public synchronized void executePrint(ThreadExecute st){
		System.out.println("Inside Execute Print "+Thread.currentThread().getName()+"  object hashcode  "+t.hashCode());
	}
}

public class SingleThread {
	public static void main(String[] args) throws InterruptedException{
		Thread t[] = new Thread[10];
		for(int i=0; i<10; i++){
			t[i] = new Thread(new ThreadExecute());
			t[i].start();
			
			t[i].join();
		}
		Map<Thread, StackTraceElement[]> m = Thread.getAllStackTraces();
		for(Thread loopt:m.keySet()){
			StackTraceElement[] loopStackTrace = m.get(loopt);
			System.out.println("\n Stack Trace for Element:"+loopt.getName()+ "  - loopStack: \n" + Arrays.toString(loopStackTrace));
			loopStackTrace = null;
		}
	}
}

