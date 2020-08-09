package applet.algorithm.queue;

import applet.algorithm.link.Node;

/**
 * 链表实现队列
 */
public class LinkQueue {
    private Node head = null;
    private Node tail = null;
    private int count = 0;//队列已有元素个数
    private int n = 0;//队列容量

    public LinkQueue(int n){//定义链表的长度
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
        String value = head.getValue().toString();
        head = head.next;
        count--;
        return value;
    }

    /**
     * 入队
     * @param value
     * @return
     */
    public boolean push(String value){
        if(count == n){
            return false;
        }
        tail.next = new Node(value);
        tail = tail.next;
        count++;
        return true;
    }

}
