package evolution.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnyClass {
	public void anyMethod() {
		ExecutorService executor = Executors.newCachedThreadPool();
		// Also keep in mind that the return type is Future.
		executor.submit(() -> {
			while (true) {
				System.out.println("Hello World");
			}
		});
		executor.submit(new Runnable() {// The anonymous class can be replaced by lambda expression if you are using JDK 8 or above.
			@Override
			public void run() {
				while (true) {
					System.out.println("Goodbye Past");
				}
			}
		});
	}
	
	public static void main(String[] args) {
		AnyClass anyClass = new AnyClass();
		anyClass.anyMethod();
	}
}
