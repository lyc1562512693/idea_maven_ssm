package myThread.thread2;

public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TerminatedExecutor te = new TerminatedExecutor();
		te.countDownLatchExecute();
		//te.terminatedExecute();
	}

}
