package applet.algorithm.queue;

public class ArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int length){
        this.items = new String[length];
        this.n = length;
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
            for(int i = head; i< tail;i++){
                items[i-head] = items[i];
            }
            tail-=head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }
}
