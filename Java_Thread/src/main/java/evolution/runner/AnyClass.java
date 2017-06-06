package evolution.runner;

public class AnyClass {
	public <T> void anyMethod() {
	    CallBackThread thread = new CallBackThread(new Runner() {
			public void execute() {
				while (true) {
					System.out.println("Hello World");
				}
			}
		});
		thread.start();
	}
	
	public static void main(String[] args) {
		new AnyClass().anyMethod();
	}
}
