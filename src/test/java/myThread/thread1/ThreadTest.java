package myThread.thread1;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {

	public static void main(String[] args){

		//singleThreadObject();
		//multiThreadObject();
		//singlePC();
		multiPC();
	}

	/**
	 * 单个实例，各个线程使用同一对象的实例变量及方法，线程非安全
	 */
	public static void singleThreadObject(){
		MyThread myThread = new MyThread("窗口1");
		Thread t1 = new Thread(myThread,"线程一");
		Thread t2 = new Thread(myThread, "线程二");
		Thread t3 = new Thread(myThread,"线程三");
		Thread t4 = new Thread(myThread, "线程四");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	/**
	 * 多个对象实例，各个线程都要自己的私有实例变量，线程安全
	 */
	public static void multiThreadObject(){
		MyThread t1 = new MyThread("线程一");
		MyThread t2 = new MyThread("线程二");
		MyThread t3 = new MyThread("线程三");
		MyThread t4 = new MyThread("线程四");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	/*public static void singlePC(){
		String lock = new String("lock");
		P p = new P(lock);
		C c = new C(lock);
		p.start();
		c.start();
	}*/
	public static void multiPC(){
		String lock = new String("");
		List<String> lst = new ArrayList<>();
		P p = new P(lock,lst);
		C c1 = new C(lock,lst);
		C c2 = new C(lock,lst);
		C c3 = new C(lock,lst);
		p.start();


		c1.start();
		c2.start();
		c3.start();

	}
}
