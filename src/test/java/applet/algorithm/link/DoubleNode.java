package applet.algorithm.link;

/**
 * 双向链表
 */
public class DoubleNode {
    private Object value;//值私有
    public DoubleNode pre;//前一个及下一个节点指针共有，便于直接访问
    public DoubleNode next;
    public DoubleNode(Object value){//构造函数只需初始化value
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public DoubleNode getPre() {
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "value=" + value +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }
}
