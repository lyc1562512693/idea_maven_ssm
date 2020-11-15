package myThread.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class TheAQS {
    public static void main(String[] args) {

    }
    public void aqsTest(){
        new ReentrantLock();
        new ReadWriteLock() {
            @Override
            public Lock readLock() {
                return null;
            }

            @Override
            public Lock writeLock() {
                return null;
            }
        };
        new CountDownLatch(5);
        new CyclicBarrier(5);
    }
}
