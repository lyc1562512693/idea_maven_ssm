package applet.algorithm.link;

import java.util.HashSet;
import java.util.Set;

/**
 * 单链表反转
 * 链表的中环检测
 * 两个有序链表的合并
 * 删除链表倒数第n个节点
 * 求链表的中间节点
 */
public class LinkUtils2 {
    public static void main(String[] args) {
        Node headA = string2Link("123567");
        Node headB = string2Link("49");
        Node newHead = mergeOrderLinkA(headA,headB);
        printLink(newHead);
    }

    /**
     * 字符串转链表
     * @param str
     * @return
     */
    public static Node string2Link(String str){
        Node head = new Node(str.charAt(0));
        Node temp = head;
        for(int i = 1;i<str.length();i++){
            Node newNode = new Node(str.charAt(i));
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printLink(Node head){
        if(head == null){
            return ;
        }
        while(head.next != null){
            System.out.print(head.getValue() + ",");
            head = head.next;
        }
        System.out.println(head.getValue());
    }

    /**
     * 单链表反转
     * @param node
     * @return
     */
    public static Node reverseLink(Node node){
        if(node == null){
            return null;
        }
        Node newHead = null;
        while(node != null){
            Node temp = node;
            node = node.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }
    /**
     * 链表中环检测（快慢指针法）
     * @param node
     * @return
     */
    public static boolean ringLinkCheckA(Node node){
        if(node == null){
            return false;
        }
        Node slow = node;
        Node fast = node.next;
        while(fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * 链表中环检测（hashSet法）
     * @param node
     * @return
     */
    public static  boolean ringLinkCheckB(Node node){
        Set<Node> set = new HashSet<>();
        while(node != null){
            if(set.contains(node)){
                return true;
            }
            set.add(node);
            node = node.next;
        }
        return false;
    }

    /**
     * 合并两个有序链表（假设链表是升序的）-使用哨兵节点
     * @param headA
     * @param headB
     * @return
     */
    public static Node mergeOrderLinkA(Node headA, Node headB){
        if(headA == null){
            return headB;
        }
        if(headB == null){
            return headA;
        }
        Node newHead = new Node("0");
        Node temp = newHead;
        while(headA != null && headB != null){
            if(Integer.parseInt(headA.getValue().toString()) < Integer.parseInt(headB.getValue().toString())){
                temp.next = headA;
                headA = headA.next;
                temp = temp.next;
            }else{
                temp.next = headB;
                headB = headB.next;
                temp = temp.next;
            }
        }
        if (headA != null) {
            temp.next = headA;
        }
        if(headB != null){
            temp.next = headB;
        }
        return newHead.next;
    }

    /**
     * 根据索引删除正数第n个节点
     * @param head
     * @return
     */
    public static Node delNodeByIndexAsc(Node head, int n){
        //先考虑不合法情况（n>size的暂时不在这里判断）
        if(head == null){
            return null;
        }
        if(n < 1){
            throw new IndexOutOfBoundsException();
        }
        //再考虑删除第一个节点的特殊情况
        if(n == 1){
            return head.next;
        }
        //再考虑其他情况，顺便处理n>size的情况
        Node temp = head;
        while(temp != null){
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
     * 根据索引删除正数第n个节点（提前判断n是否大于链表长度）
     * @param head
     * @return
     */
    public static Node delNodeByIndexAscB(Node head, int n){
        //先考虑不合法情况
        if(head == null){
            return null;
        }
        int size = 0;
        Node node = head;
        while(node != null){//求链表长度，便于判断n是否大于链表长度
            size++;
            node = node.next;
        }
        if(n < 0 || n > size){
            throw new IndexOutOfBoundsException();
        }
        //再考虑删除第一个节点的特殊情况
        if(n == 1){
            return head.next;
        }
        //再考虑其他情况，顺便处理n>size的情况
        Node temp = head;
        while(temp != null){
            if(--n == 1){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    /**
     * 根据索引删除倒数第n个节点-快慢指针
     * @param head
     * @param n
     * @return
     */
    public static Node delNodeByIndexDesc(Node head, int n){
        if(n < 1){
            throw new IndexOutOfBoundsException();
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && --n > 0){//快指针先走到正数第n个节点（这个while循环的写法要记住）
            fast = fast.next;
        }
        if(n > 0){//如果此时n还是大于0，那坑定是给的n太大了，超出链表长度了
            throw new IndexOutOfBoundsException();
        }
        //程序走到这里说明此时n==0
        //判断删除的是否为倒数第length个节点（即正数第一个节点）
        if(fast.next == null){
            return head.next;
        }
        //其他情况则直接slow.next = slow.next.next;
        fast = fast.next;//为了找到待删节点的pre节点，fast需要先往前一步
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    /**
     * 返回链表的中间节点-快慢指针
     * @param head
     * @return
     */
    public static Node getMidNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
