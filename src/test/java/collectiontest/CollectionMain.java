package collectiontest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.management.Query;

public class CollectionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList2<Map<String,Object>>[] list = new MyLinkedList2[10];
		long q1 = System.currentTimeMillis();
		for(int i=0;i<10;i++){
			if(list[i]==null){
				list[i] = new MyLinkedList2<Map<String,Object>>();
			}
			for(int j=10;j<200000;j++){
				Map<String,Object> m = new HashMap<>();
				m.put(i+"user"+(int)((i+1)*(Math.random()*10)), j+"score");
				list[i].add(m);
			}
		}
		long q2 = System.currentTimeMillis();
		System.out.println("初始化集合耗时："+(q2-q1));
		long x1 = System.currentTimeMillis();
		for(int i=1;i<list.length;i++){
			list[0].link2List(list[i]);
		}
		long x2 = System.currentTimeMillis();
		System.out.println("自定义链表方式连接链表耗时："+(x2-x1));
		//System.out.println(list[0].toString());
		System.out.println("集合长度："+list[0].size());
	}
}
