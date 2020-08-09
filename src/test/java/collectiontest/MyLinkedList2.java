package collectiontest;


/**
 * 自定义链表类
 * @author lyc
 *
 * @param <E>
 */
public class MyLinkedList2<E>{


	public class MyNode<E> {

		E data;
		MyNode<E> next;

		public MyNode(E data){
			this.data = data;		
		}
		public MyNode(E data, MyNode<E> next){
			this.data = data;
			this.next = next;
		}
	}
	private MyNode<E> head;
	
	private MyNode<E> tail;

	//public MyNode last;
	
	public MyLinkedList2(){
		head = null;
		tail = null;
	}
	
	public MyNode<E> getHead() {
		return head;
	}

	public void setHead(MyNode<E> head) {
		this.head = head;
	}

	public MyNode<E> getTail() {
		return tail;
	}

	public void setTail(MyNode<E> tail) {
		this.tail = tail;
	}

	/**
	 * 添加新节点到链表尾部
	 * @param data 待添加节点
	 */
	public void add(E data){
		MyNode<E> newNode = new MyNode<>(data);
		newNode.next = null;
		if(head == null){
			head = newNode;
			tail = newNode;
		}else{
			tail.next = newNode;
		}
		tail = newNode;
	}
	/**
	 * 重写toString方法，方便输出
	 * @return 格式化输出结果
	 */
	public String toString(){
		if(head == null){
			return "Empty link!";
		}
		MyNode<E> node = head;
		StringBuilder sb = new StringBuilder();
		while(node.next!=null){
			sb.append(node.data+",");
			node = node.next;
		}
		sb.append(node.data);
		return sb.toString();
	}
	/**
	 * 统计集合长度
	 * @return 返回当前集合长度
	 */
	public int size(){
		if(head == null){
			return 0;
		}else{
			MyNode<E> temp = head;
			int i = 1;
			while(temp.next!=null){
				temp = temp.next;
				i++;
			}
			return i;
		}
	}
	/**
	 * 获取链表集合的尾节点
	 * @return 返回当前链表的尾节点
	 */
	/*public MyNode<E> getLast(){
		if(head == null){
			return null;
		}else{
			MyNode<E> temp = head;
			while(temp.next!=null){
				temp = temp.next; 
			}
			return temp;
		}
	}*/
	/**
	 * 连接两个双向向链表
	 * @param lstB 为待连接的链表
	 */
	public void link2List(MyLinkedList2<E> lstB){	
		this.tail.next = lstB.head;
		this.tail = lstB.getTail();
	}
	
}
