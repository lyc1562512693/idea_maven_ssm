package myThread.threadpool;

public class Task {

	public void run(String threadName) {
		for(int i=1;i<=10;i++) {
			System.out.println(threadName+"正在处理第"+i+"个任务");
		}
	}
}
