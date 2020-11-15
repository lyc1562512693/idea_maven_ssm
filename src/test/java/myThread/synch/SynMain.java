package myThread.synch;

public class SynMain {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {SynTest.getIdPro(123);});
        t1.start();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(() -> SynTest.getIdPro2());
        t2.start();
    }
}
