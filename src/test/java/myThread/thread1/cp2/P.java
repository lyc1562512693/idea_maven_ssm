package myThread.thread1.cp2;

import java.util.List;

public class P implements Runnable{
    private Object lockP;
    //private Object lockC;
    private List<Integer> item;
    public P(Object lockP, /*Object lockC,*/ List<Integer> item){
        this.lockP = lockP;
        //this.lockC = lockC;
        this.item = item;
    }

    @Override
    public void run() {
        //producePro();
        produce();
    }
    public void produce(){
        try {
            while (true) {
                synchronized (lockP) {
                    while (item.size() == 0) {
                        lockP.wait();
                    }
                    int i = item.remove(0);
                    System.out.println(Thread.currentThread().getName()+"消费者从集合item中拿出了"+i);
                    lockP.notifyAll();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //以下方式是错误的，运行报错，不能再一把锁中调用另一把锁的wait或者notify
//    public void producePro(){
//        try {
//            while (true) {
//                synchronized (lockP) {
//                    while (item.size() == 0) {
//                        lockP.wait();
//                    }
//                    int i = item.remove(0);
//                    System.out.println(Thread.currentThread().getName()+"消费者从集合item中拿出了"+i);
//                    lockC.notifyAll();
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
