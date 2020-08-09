package myThread.thread1;

import java.util.List;

/**
 * 生产者
 */
public class P extends Thread {
    private String lock;//锁对象，可以使用synchronized方法代替
    private List<String> lst;//生产消费的产品
    public P(String lock,List<String> lst){
        this.lock = lock;
        this.lst = lst;
    }
    public void run(){
        //while(true){//这里的while的作用是保证循环消费与生产（不断的消费生产，而不是只生产消费一次），放在synchronized下面效果一致
            synchronized(lock){
                try {
                    while(lst.size() != 0){//这个while是代替if，保证被换成以后，可以多判断一次，放在代码直接往下走，导致一些空指针及数组越界问题
                        lock.wait();
                    }
                    lst.add("time_"+System.currentTimeMillis());
                    System.out.println(Thread.currentThread().getName() +"-set的值是："+lst.get(0));
                    lock.notifyAll();//这里用notifyAll是为了防止假死情况（及消费者唤醒了另一个消费者，或者生产者唤醒了另一个生产者）
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        //}
    }
}
