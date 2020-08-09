package myThread.thread1;

import java.util.List;

/**
 * 消费者
 */
public class C extends Thread {
    private String lock;
    private List<String> lst;
    public C(String lock,List<String> lst){
        this.lock = lock;
        this.lst = lst;
    }
    public void run(){
        synchronized(lock){
            try {
                while(lst.size() == 0){
                    lock.wait();
                }
                System.out.println(Thread.currentThread().getName() +"-get的值是："+lst.get(0));
                lst.remove(0);
                lock.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
