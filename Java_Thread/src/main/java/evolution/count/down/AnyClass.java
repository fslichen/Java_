package evolution.count.down;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnyClass {
	private static final int N = 5;
	
	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(N);
	    ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	    for (int i = 0; i < N; i++) {
	    		service.submit(new Runnable() {
	    			@Override
	    			public void run() {
	    				try {
		    				Thread.sleep(1000);
		    			} catch (InterruptedException e) {}
		    			latch.countDown();// Latch counts down by one once a task is done.
		    			System.out.println("The sub-task is done.");
	    			}
	    		});
	    }
	    latch.await();// Wait for all the tasks to be done.
	    System.out.println("All the taskes are done.");
	}
}
