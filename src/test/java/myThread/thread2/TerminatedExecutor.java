package myThread.thread2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TerminatedExecutor {

	private static CountDownLatch cdl = new CountDownLatch(5);

	public void countDownLatchExecute(){
		System.out.println("countDownLatch main thread begin..");
		countDownLatchCore();
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("when all the son thread is over,I continue executing");
	}
	public void countDownLatchCore(){
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i = 0;i<5;i++){
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("子线程"+Thread.currentThread().getName()+"启动");
					System.out.println(Thread.currentThread().getName() + "do something");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "over");
					cdl.countDown();
				}
			});
			
		}
		executor.shutdown();
		System.out.println("关闭已完成的任务");
	}
	public void terminatedExecute(){
		System.out.println("terminated main is begin...");
		terminatedCore();
		System.out.println("terminated main continue executing");
	}
	public void terminatedCore(){
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i = 0;i<5;i++){
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("子线程"+Thread.currentThread().getName()+"启动");
					System.out.println(Thread.currentThread().getName() + "do something");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "over");
				}
			});
			
		}
		executor.shutdown();
		while(!executor.isTerminated()){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("定时方法执行");
		}
		System.out.println("All the son thread is over");
	}
}
