package myThread.thread1.cp2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class CPMain {
    public static void main(String[] args) {
        //synCP();
        lockCP();
        //Executors.newFixedThreadPool();
        //Executors.newCachedThreadPool();
        //Executors.newScheduledThreadPool();
        //Executors.newSingleThreadExecutor();
    }
    public static void synCP(){
        Object oc = new Object();
        List<Integer> item = new ArrayList<>();
        C c = new C(oc,item);
        Thread c1 = new Thread(c,"C1");
        Thread c2 = new Thread(c, "C2");
        Thread c3 = new Thread(c, "C3");

        P p = new P(oc,item);
        Thread p1 = new Thread(p, "P1");
        Thread p2 = new Thread(p, "P2");
        Thread p3 = new Thread(p,"P3");

        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        ReadWriteLock rw = new ReadWriteLock() {
            @Override
            public Lock readLock() {
                return null;
            }

            @Override
            public Lock writeLock() {
                return null;
            }
        };
    }
    public static void lockCP(){
        ReentrantLock lock = new ReentrantLock();
        Condition conditionC = lock.newCondition();
        Condition conditionP = lock.newCondition();
        List<Integer> lst = new ArrayList<>();
        ReentrantLockC c =  new ReentrantLockC(lock,conditionC,conditionP,lst);
        Thread c1 = new Thread(c,"C1");
        Thread c2 = new Thread(c, "C2");
        Thread c3 = new Thread(c, "C3");
        ReentrantLockP p = new ReentrantLockP(lock,conditionP,conditionC,lst);
        Thread p1 = new Thread(p, "P1");
        Thread p2 = new Thread(p, "P2");
        Thread p3 = new Thread(p,"P3");
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
    }
}
