package applet.algorithm.queue;

/**
 * 数组实现循环队列
 * 对于这种循环的数据结构，假设总容量为n，当前位置为curIndex：当下标从0开始，则nextIndex=(curIndex+1)%n；当下标从1开始，则nextIndex=curIndex%n+1
 */
public class CycleQueue {
    private String[] items;
    private int head = 0;
    private int tail = 0;
    private int n = 0;

    public CycleQueue(int n){
        items = new String[n];
        this.n = n;
    }

    /**
     * 出队
     * @return
     */
    public String pull(){
        if(head == tail){
            return null;
        }
        String value = items[head];
        head = (head + 1)%n;
        return value;
    }

    /**
     * 入队
     * @param value
     * @return
     */
    public boolean push(String value){
        if((tail + 1)%n == head){//判端是否队列已满(即必须满足tail紧跟在head后面)
            return false;
        }
        items[tail] = value;
        tail = (tail + 1)%n;
        return true;
    }
}
