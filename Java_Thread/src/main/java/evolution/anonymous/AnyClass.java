package evolution.anonymous;

public class AnyClass {
	public void anyMethod() {
		Thread thread0 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					System.out.println("Hello World");
				}
			}
		});
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					System.out.println("Goodbye Past");
				}
			}
		});
		thread0.start();
		thread1.start();
	}
	
	public static void main(String[] args) {
		new AnyClass().anyMethod();
	}
}
