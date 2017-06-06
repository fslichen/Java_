package evolution.lambda;

public class AnyClass {
	public void anyMethod() {
		// Runnable is a functional interface because it has
		// only one method.
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("Hello World");
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
	
	public void anotherMethod() {
		// A functional interface can be replaced by lambda expression.
		Runnable runnable = () -> {
			while (true) {
				System.out.println("Goodbye Past");
			}
		};
		Thread thread = new Thread(runnable);// You are treating the method as a parameter.
		thread.start();
	}
	
	public static void main(String[] args) {
		AnyClass anyClass = new AnyClass();
		anyClass.anyMethod();
		anyClass.anotherMethod();
	}
}
