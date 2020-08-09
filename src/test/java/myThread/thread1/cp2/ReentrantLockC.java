package myThread.thread1.cp2;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
//生产者
public class ReentrantLockC implements Runnable{
    private Lock lock;
    private Condition conditionC;
    private Condition conditionP;
    private List<Integer> item;
    private int i = 0;
    public ReentrantLockC(Lock lock,Condition conditionC,Condition conditionP, List<Integer> item){
        this.lock = lock;
        this.conditionC = conditionC;
        this.conditionP = conditionP;
        this.item = item;
    }
    @Override
    public void run() {
        //consumer();
        consumerPro();
    }
    public void consumer(){
        while (true) {
            try {
                lock.lock();
                while (item.size() != 0) {
                    conditionC.await();
                }
                System.out.println(Thread.currentThread().getName()+"生产者往集合item里添加了"+i);
                item.add(i++);
                conditionC.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    //优化版，仅唤醒同类线程
    public void consumerPro(){
        while (true) {
            try {
                lock.lock();
                while (item.size() != 0) {
                    conditionC.await();
                }
                System.out.println(Thread.currentThread().getName()+"生产者往集合item里添加了"+i);
                item.add(i++);
                conditionP.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}

