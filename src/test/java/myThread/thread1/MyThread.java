package myThread.thread1;

public class MyThread extends Thread{
	
	private  int i=1;
	public MyThread(String name){
		super(name);
	}
	
	public void run(){
		//synchronized(ThreadTest.class){
			
			for(;i<=100;i++){
				System.out.println(Thread.currentThread().getName()+i);
			}
		//}
	}
	
}
