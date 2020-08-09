package myThread.thread1.cp2;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
//生产者
public class ReentrantLockP implements Runnable{
    private Lock lock;
    private Condition conditionP;
    private Condition conditionC;
    private List<Integer> item;
    private int i = 0;
    public ReentrantLockP(Lock lock,Condition conditionP, Condition conditionC, List<Integer> item){
        this.lock = lock;
        this.conditionP = conditionP;
        this.conditionC = conditionC;
        this.item = item;
    }

    @Override
    public void run() {
        //produce();
        producePro();
    }

    public void produce(){
        while (true) {
            try {
                lock.lock();
                while (item.size() == 0) {
                    conditionP.await();
                }
                int i = item.remove(0);
                System.out.println(Thread.currentThread().getName()+"消费者从集合item中拿出了"+i);
                conditionP.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    //优化版，仅唤醒同类线程
    public void producePro(){
        while (true) {
            try {
                lock.lock();
                while (item.size() == 0) {
                    conditionP.await();
                }
                int i = item.remove(0);
                System.out.println(Thread.currentThread().getName()+"消费者从集合item中拿出了"+i);
                conditionC.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
