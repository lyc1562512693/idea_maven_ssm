package applet.algorithm.link;

/**
 * 使用链表实现lRU缓存淘汰算法（删除最近最少使用的节点）
 * 实现：维护一个单链表，越靠近尾部则是越早之前访问的，遍历时始终从头部开始遍历
 * 当访问指定数据时时：
 * 1.当链表中存在该数据，则遍历找到该数据并从原来位置删除，然后将该数据插入链表头部
 * 2.当链表中不存在该数据
 * （1）如果链表未满，则直接插入链表头部
 * （2）如果链表已满，则删除尾节点，并将该数据插入链表头部
 */
public class LRULink {
    private Node head = null;//链表头节点
    private int currentSize = 0;//链表当前已占用大小
    private int totalSize;//链表总大小
    public LRULink(int totalSize){
        this.totalSize = totalSize;
    }

    /**
     * 核心方法：使用lRU添加淘汰数据
     * @param value
     */
    public void deleteByLRU(Object value){
        Node node = head;
        //1.当链表中存在该数据，则遍历找到该数据并从原来位置删除，然后将该数据插入链表头部
        for(int i = 1;node != null;i++){
            if(node.getValue().equals(value)) {
                delNodeByIndexAsc(head, i);//删除当前节点
                //将当前节点查到链表头部
                Node newNode = new Node(value);
                newNode.next = head;
                head = newNode;
                return;
            }
            node = node.next;
        }
        //2.当链表中不存在该数据（1）如果链表未满，则直接插入链表头部
        if(currentSize < totalSize){
            //将当前节点查到链表头部
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            currentSize++;
            return;
        }
        //2.当链表中不存在该数据（2）如果链表已满，则删除尾节点，并将该数据插入链表头部
        delNodeByIndexAsc(head, totalSize);//删除尾节点
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    /**
     * 删除链表的第n个节点
     * @param head
     * @param n
     * @return
     */
    public static Node delNodeByIndexAsc(Node head,int n){
        if(head == null){
            return head;
        }
        if(n < 1){
            throw new IndexOutOfBoundsException();
        }
        if(n == 1){
            return head.next;
        }
        Node temp = head;
        while(temp != null ){
            if(--n == 1){
                if(temp.next != null){
                    temp.next = temp.next.next;
                    break;
                }else{
                    throw new IndexOutOfBoundsException();
                }
            }
            temp = temp.next;
        }
        if(n > 1){
            throw new IndexOutOfBoundsException();
        }
        return head;
    }

    /**
     * 从头开始打印链表
     */
    public void printLink(){
        Node node = head;
        while(node != null){
            System.out.print(node.getValue()+",");
            node = node.next;
        }
    }
    public static void main(String[] args) {
       LRULink link =  new LRULink(4);
       link.deleteByLRU("qwe");
        link.deleteByLRU("123");
        link.deleteByLRU("wwa");
        link.deleteByLRU("www");
        link.deleteByLRU("aaa");

       link.printLink();
    }

}
