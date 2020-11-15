package myThread.threadpool;

public class ThreadPoolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����:�����������5�������̣߳�����֮����һ������������ô��ʱshutdownֻ�ܹص�һ���߳�
		Task task1 = new Task();
		Task task2 = new Task();
		Task task3 = new Task();
		ThreadPool tp = new MyThreadPoolImpl(5);
		tp.execute(task1);
		tp.execute(task2);
		tp.execute(task3);
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		tp.shutDown();
		
	}

}
