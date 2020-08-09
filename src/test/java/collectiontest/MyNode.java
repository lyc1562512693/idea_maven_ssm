package collectiontest;

public class MyNode<E> {

	public Object data;
	MyNode<E> next;

	public MyNode(Object data){
		this.data = data;		
	}
	public MyNode(Object data, MyNode<E> next){
		this.data = data;
		this.next = next;
	}
}
