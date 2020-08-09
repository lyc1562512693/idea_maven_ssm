package myThread.thread1.cp2;

import java.util.List;

public class C implements Runnable{
    private Object lockC;
    //private Object lockP;
    private List<Integer> item;
    private int i = 0;
    public  C(Object lockC, /*Object lockP,*/ List<Integer> item){
        this.lockC = lockC;
        //this.lockP = lockP;
        this.item = item;
    }

    @Override
    public void run() {
        //consumerPro();
        consumer();
    }
    public void consumer(){
        try {
            while (true) {
                synchronized (lockC) {
                    while (item.size() > 10) {
                        lockC.wait();
                    }
                    System.out.println(Thread.currentThread().getName()+"生产者往集合item里添加了"+i);
                    item.add(i++);
                    lockC.notifyAll();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //以下方式是错误的，运行报错，不能再一把锁中调用另一把锁的wait或者notify;但是ReentrantLock支持
//    public void consumerPro(){
//        try {
//            while (true) {
//                synchronized (lockC) {
//                    while (item.size() != 0) {
//                        lockC.wait();
//                    }
//                    System.out.println(Thread.currentThread().getName()+"生产者往集合item里添加了"+i);
//                    item.add(i++);
//                    lockP.notifyAll();
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
