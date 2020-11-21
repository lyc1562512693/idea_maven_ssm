package myThread.synch;

public class SynTest {
    private int id;
    private static String name = "qwe";
    public void getId(){
        synchronized(this){//[2]
            System.out.println("this 方法开始");
        }
    }
    public static void getIdPro(int idPro){
        synchronized(SynTest.class){//[3]
            System.out.println("静态方法pro开始"+System.currentTimeMillis()/1000);
            try {
                Thread.currentThread().sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("静态方法pro结束"+System.currentTimeMillis()/1000);
        }
    }
    public synchronized static void getIdPro2(){
        System.out.println("静态方法pro2开始");
    }
}
