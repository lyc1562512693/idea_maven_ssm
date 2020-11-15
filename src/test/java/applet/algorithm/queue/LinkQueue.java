package applet.algorithm.queue;

import applet.algorithm.link.Node;

/**
 * 链表实现队列
 */
public class LinkQueue {
    private Node head = null;
    private Node tail = null;


    /**
     * 出队
     * @return
     */
    public String pull(){
        if(head == null){
            return null;
        }
        String value = head.getValue().toString();
        head = head.next;
        if(head == null){
            tail = null;
        }
        return value;
    }

    /**
     * 入队
     * @param value
     * @return
     */
    public boolean push(String value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = tail.next;
        }
        return true;
    }

}
