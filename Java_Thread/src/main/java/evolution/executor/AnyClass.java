package evolution.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AnyClass {
	public static void main(String[] args) throws InterruptedException {
		Callable<String> callable0 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(4000);
				return "Hello World";
			}
		};
		Callable<String> callable1 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "Goodbye Past";
			}
		};
		ExecutorService service = Executors.newCachedThreadPool();
		// The timeout is not for the entire task pool, rather it's for each one of the task.
		// That means, if you set the timeout as 3 seconds, any task exceeds 3 seconds will be aborted. 
		// And any task that takes less than 3 seconds is executed.
		List<Future<String>> futures = service.invokeAll(Arrays.asList(callable0, callable1), 3, TimeUnit.SECONDS);
		futures.forEach(future -> {
			try {
				String result = future.get();
				System.out.println(result);
			} catch (Exception e) {}
		});
	}
}
