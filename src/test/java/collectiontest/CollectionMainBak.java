package collectiontest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollectionMainBak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long q1 = System.currentTimeMillis();
		List<Map<String,Object>>[] list = new LinkedList[10];
		for(int i=0;i<10;i++){
			if(list[i]==null){
				list[i] = new LinkedList<Map<String,Object>>();
			}
			for(int j=10;j<200000;j++){
				Map<String,Object> m = new HashMap<>();
				m.put(i+"user"+(int)((i+1)*(Math.random()*10)), j+"score");
				list[i].add(m);
			}
		}
		long q2 = System.currentTimeMillis();
		System.out.println("初始化集合耗时："+(q2-q1));
		//System.out.println(list);
		long x1 = System.currentTimeMillis();
		for(int i=1;i<list.length;i++){
			merge2SortedLindedList(list[0],list[i]);
		}
		long x2 = System.currentTimeMillis();
		System.out.println("使用list集合方式连接两个集合耗时："+(x2-x1));
		//System.out.println(list[0].toString());
		System.out.println("集合长度："+list[0].size());
	}
	/**
	 * 合并各个捅
	 * 
	 * @param info
	 * @return
	 */
	public static List<Map<String, Object>> merge2SortedLindedList(List<Map<String, Object>> buckets,
			List<Map<String, Object>> buckets2) {
		if (buckets2 != null) {
			for (Map<String, Object> log : buckets2) {
				buckets.add(log);
			}
		}
		return buckets;
	}

}
