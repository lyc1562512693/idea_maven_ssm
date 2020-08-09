package applet.algorithm.link;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

/**
 * 链表工具类：
 * 单链表反转
 * 链表的中环检测
 * 两个有序链表的合并
 * 删除链表倒数第n个节点
 * 求链表的中间节点
 * 总结：
 * （1）Node head = null;
 *      Node temp = head;
 *   如果temp.next = xxx;则会同时改变head.next;head和temp的value都没变。
 *   如果temp = temp.next(node1.next);则不会改变head，temp的next和value都变了。
 *
 *
 *   链表边界问题考虑：
 *   1.链表为空时
 *   2.链表只包含一个节点时
 *   3.链表只包含两个节点时
 *   4.代码逻辑在处理头节点或尾节时
 */
public class LinkUtils {
    public static void main(String[] args) {
        Node headA = StringToLink("123456");
        //Node headB = StringToLink("2459");
       // Node newHead =  mergeOrderLinkA(headA,headB);
        //Node newHead = getMidelNode(headA);
       delNodeByIndexAsc(headA,2);
        printLink(headA);
    }

    /**
     * String转为链表
     * @param string
     * @return
     */
    public static Node StringToLink(String string){
        if(string == null){
            return null;
        }
        Node head = new Node(string.charAt(0));
        Node pre = head;
        for(int i =1; i<string.length(); i++){
            Node node = new Node(string.charAt(i));
            pre.next = node;
            pre = pre.next;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printLink(Node head){
        if(head == null){
            return;
        }
        while(head.next != null){
            System.out.print(head.getValue()+",");
            head = head.next;
        }
        System.out.println(head.getValue());
    }

    /**
     * 单向链表反转
     * @param head
     * @return
     */
    public static Node reverse(Node head){
        Node newHead = null;
        //Node temp = null;
        while(head != null){
            Node temp = head;
            head = head.next;
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
    public static boolean isRingLinkA(Node node){
        if(node == null){
            return false;
        }
        Node slow = node;
        Node fast = node.next;
        while(fast != null && fast.next != null){
            if(fast == slow){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * 链表中环检测（hash集合标记法）
     * @param node
     * @return
     */
    public static boolean isRingLinkB(Node node){
        Set<Node> set = new HashSet<>();
        while(node != null){
            if(!set.contains(node)){
                set.add(node);
                node = node.next;
            }else{
                return true;
            }
        }
        return false;
    }
    /**
     * 将两个有序链表进行合并（假设两个链表是升序的）,输出结果和原始序列相同（使用哨兵节点初始化新链表）
     * @param headA
     * @param headB
     * @return
     */
    public static Node mergeOrderLinkA(Node headA, Node headB){
        if(headB == null){
            return headA;
        }
        if(headA == null){
            return headB;
        }
        Node newHead = new Node("0");
        Node temp = newHead;
        while(headA != null && headB != null){
            if(Integer.parseInt(headA.getValue().toString()) < Integer.parseInt(headB.getValue().toString())){
                temp.next = headA;
                temp = temp.next;
                headA = headA.next;
            } else {
                temp.next = headB;
                temp = temp.next;
                headB = headB.next;
            }
        }
        //链表B遍历完了，发现A还没有遍历完，则继续将A的剩余节点给新链表
        if(headA != null){
            temp.next = headA;
        }
        //链表A遍历完了，发现B还没有遍历完，则继续将B的剩余节点给新链表
        if(headB != null){
            temp.next = headB;
        }
        return newHead.next;
    }

    /**
     * 将两个有序链表进行合并（假设两个链表是升序的）,输出结果和原始序列相同（不用哨兵）
     * @param headA
     * @param headB
     * @return
     */
    public static Node mergeOrderLinkB(Node headA, Node headB){
        if(headB == null){
            return headA;
        }
        if(headA == null){
            return headB;
        }
        Node temp = null;
        if(Integer.parseInt(headA.getValue().toString()) < Integer.parseInt(headB.getValue().toString())){
            temp = headA;
            headA = headA.next;
        }else{
            temp = headB;
            headB = headB.next;
        }
        Node newHead = temp;
        while(headA != null && headB != null){
            if(Integer.parseInt(headA.getValue().toString()) < Integer.parseInt(headB.getValue().toString())){
                temp.next = headA;
                temp = temp.next;
                headA = headA.next;
            } else {
                temp.next = headB;
                temp = temp.next;
                headB = headB.next;
            }
        }
        //链表B遍历完了，发现A还没有遍历完，则继续将A的剩余节点给新链表
        if(headA != null){
            temp.next = headA;
        }
        //链表A遍历完了，发现B还没有遍历完，则继续将B的剩余节点给新链表
        if(headB != null){
            temp.next = headB;
        }
        return newHead;
    }
    /**
     * 将两个有序链表进行合并（假设两个链表是升序的）,输出结果和原始序列相反
     * @param headA
     * @param headB
     * @return
     */
    public static Node mergeOrderLinkC(Node headA, Node headB){
        Node newHead = null;
        if(headB == null){
            return reverse(headA);
        }
        if(headA == null){
            return reverse(headB);
        }
        while(headA != null && headB != null){
            if(Integer.parseInt(headA.getValue().toString()) < Integer.parseInt(headB.getValue().toString())){
                Node tempA = headA;
                headA = headA.next;
                tempA.next = newHead;
                newHead = tempA;
                //headA = headA.next;
            } else {
                Node tempB = headB;
                headB = headB.next;
                tempB.next = newHead;
                newHead = tempB;
            }
        }
        //链表B遍历完了，发现A还没有遍历完，则继续将A的剩余节点给新链表
        while(headA != null){
            Node tempA = headA;
            headA = headA.next;
            tempA.next = newHead;
            newHead = tempA;
        }
        //链表A遍历完了，发现B还没有遍历完，则继续将B的剩余节点给新表
        while(headB != null){
            Node tempB = headB;
            headB = headB.next;
            tempB.next = newHead;
            newHead = tempB;
        }
        return newHead;
    }

    /**
     * 删除链表的第n个节点
     * @param head
     * @param n
     * @return
     */
    public static Node delNodeByIndexAsc(Node head,int n){
        //判断不合法的情况
        if(head == null){
            return head;
        }
        if(n < 1){
            throw new IndexOutOfBoundsException();
        }
        //n = 1的特殊情况
        if(n == 1){
            return head.next;
        }
        //其他情况
        Node temp = head;
        while(temp != null ){
            if(--n == 1){
                if(temp.next != null){
                    temp.next = temp.next.next;
                    return head;
                }
            }
            temp = temp.next;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * 删除链表倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    public static Node delNodeByIndexDesc(Node head,int n){
        //判断不合法的情况
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
        fast = fast.next;//fast需要再往后走一步，不然当fast到达最后一个节点时，slow正好到达要删掉的那个节点，这样那个节点就不好删除了，所有最后让fast到达最后一个节点时，slow到达要删节点的前一个节点
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 另一种实现（不推荐）
     * @param head
     * @param n
     * @return
     */
    public static Node delNodeByIndexDescB(Node head,int n){
        if(n <= 0){
            throw new IndexOutOfBoundsException();
        }
        Node slow = head;
        Node fast = head;
        while(--n >= 0 && fast != null){//快指针先走到第n+1个节点
            fast = fast.next;
        }
        if(n >= 0){
            throw new IndexOutOfBoundsException();
        }
        //程序走到这里说明n==-1
        //判断删除的是否为倒数第length个节点（即正数第一个节点）
        if(fast == null){
            return head.next;
        }
        //fast = fast.next;//fast需要再往后走一步，不然当fast到达最后一个节点时，slow正好到达要删掉的那个节点，这样那个节点就不好删除了，所有最后让fast到达最后一个节点时，slow到达要删节点的前一个节点
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 快慢指针法实现返回链表中间节点
     * @param head
     * @return
     */
    public static Node getMidelNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
