class MyThread extends Thread {
	private String threadName;
	
	public MyThread(String threadName) {
		this.threadName = threadName;
		
        System.out.println("Creating Thread : " + threadName);
	}
	
	@Override 
	public void run() {
		System.out.println("Running : " + threadName);
		try {
			for ( int i = 5; i >= 0; i--) {
				System.out.println("Count Thread : " + i );
				
				// Let The thread sleep for a while 
				Thread.sleep(50);
			}
		}
		catch ( InterruptedException exp ) {
			System.out.println("Thread " + threadName + " interrupting.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}
	
	@Override
	public void start() {
		System.out.println("Starting thread : " +threadName);
		
		super.start();
	}
}

public class ThreadDemo {
	public static void main (String[] args) {
	
		MyThread myThread = new MyThread("Demo Thread");
		myThread.start();
	}
}