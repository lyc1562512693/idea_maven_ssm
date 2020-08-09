package java8.stream.collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class collectTest {

	public static void main(String[] args) {
		myCollect();
	}
	
	public static void myCollect(){
		List<Integer> lst1 = Stream.of(1,2,3)
		.collect(Collectors.toList());
		Map<Integer,List<Integer>> map1 = Stream.of(11,23,4,4,5,5,67)
		.collect(Collectors.groupingBy(i -> i * i));//i*i作为key，i作为value
		System.out.println(lst1);
		System.out.println(map1);
	}
}
