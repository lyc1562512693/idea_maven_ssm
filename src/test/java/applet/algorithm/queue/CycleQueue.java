package applet.algorithm.queue;

/**
 * 数组实现循环队列
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
        head = (head + 1)/n;
        return value;
    }

    /**
     * 入队
     * @param value
     * @return
     */
    public boolean push(String value){
        if((tail + 1)/n == head){//判端是否队列已满
            return false;
        }
        items[tail] = value;
        tail = (tail + 1)/n;
        return true;
    }
}
