package evolution.runner;

public class CallBackThread extends Thread implements Runnable {
	public final Runner runner;

	public CallBackThread(Runner runner) {
		this.runner = runner;
	}

	@Override
	public void run() {
		runner.execute();
	}
}
