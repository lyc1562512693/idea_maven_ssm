package myThread.threadpool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyc
 *
 */
public class MyThreadPoolImpl implements ThreadPool {
	
	public static final int DEFAULT_THREAD_POOL_SIZE = 5;//线程池核心大小
	public static List<Task> tasks = new ArrayList<>();//任务集合
	public static List<Worker> workers = new ArrayList<>(); //工人线程1集合
	public int workerNum;
	
	/**
	 * 创建默认大小的线程池
	 */
	public MyThreadPoolImpl() {
		initWorkers(DEFAULT_THREAD_POOL_SIZE);
		System.out.println("成功创建"+DEFAULT_THREAD_POOL_SIZE+"个线程");
	}
	/**
	 * @param poolSize
	 * 创建指定大小的线程池
	 */
	public MyThreadPoolImpl(int poolSize) {
		if(poolSize>DEFAULT_THREAD_POOL_SIZE) {
			System.out.println("只能创建0到"+DEFAULT_THREAD_POOL_SIZE+"之间的线程数!");
			initWorkers(DEFAULT_THREAD_POOL_SIZE);
		}else {			
			initWorkers(poolSize);
			System.out.println("成功创建"+poolSize+"个线程");
		}
	}
	@Override
	public void execute(Task task) {
		// TODO Auto-generated method stub
		synchronized(tasks){		
			tasks.add(task);
			tasks.notifyAll();
		}
	}
	/* (non-Javadoc)
	 * 关闭线程所有线程
	 */
	@Override
	public void shutDown() {
		// TODO Auto-generated method stub
		for(Worker w :workers) {
			w.shutDown();
		}
		System.out.println("成功关闭所有线程");
	}

	@Override
	public void addWorkers(int num) {
		// TODO Auto-generated method stub

		if(num+workers.size()>DEFAULT_THREAD_POOL_SIZE) {
			num = DEFAULT_THREAD_POOL_SIZE-workers.size();
		}
		initWorkers(num);
	}

	@Override
	public void removeWorkers(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTaskNum() {
		// TODO Auto-generated method stub
		return tasks.size();
	}
	//初始化指定数量的工人线程
	public void initWorkers(int num) {
		for(int i=1;i<=num;i++) {
			Worker w = new Worker();
			workers.add(w);
			Thread t = new Thread(w,"工人线程"+i);
			t.start();
		}
		System.out.println("当前启用了"+num+"个工人线程，还有"+(DEFAULT_THREAD_POOL_SIZE-num)+"个空余工人线程可用");
	}
	/**
	 * @author lyc
	 *新建一个内部类worker作为工人线程，使用此线程处理任务
	 */
	class Worker implements Runnable{
		public boolean running = true;
		public Worker() {
			super();
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (tasks) {			
				while(running) {			
					if(tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(!tasks.isEmpty()) {
						Task task = tasks.remove(0);//从任务队列里拿出一个任务并执行			
						task.run(Thread.currentThread().getName());
					}
				}
			}
		}
		
		public void shutDown() {
			running = false;
		}
		
	}
}
