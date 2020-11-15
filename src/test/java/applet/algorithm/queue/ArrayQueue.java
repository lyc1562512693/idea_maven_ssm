package applet.algorithm.queue;

public class ArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int n){
        this.items = new String[n];
        this.n = n;
    }

    /**
     * 出队
     * @return
     */
    public String get(){
        if(head == tail){
            return null;
        }
        return items[head++];
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean add(String item){
        if(tail == n){
            return false;
        }
        items[tail++] = item;
        return true;
    }

    /**
     * 可复用入队
     * @param item
     * @return
     */
    public boolean addPro(String item){
        if(tail == n){
            if(head == 0){
                return false;
            }
            for(int i = 0; i< tail - head;i++){
                items[i] = items[i + head];
            }
            tail-=head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }
}
