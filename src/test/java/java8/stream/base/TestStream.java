package java8.stream.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

	public static void main(String[] args) {
		testStream2();
	}
	//给定两个数字列表，如何返回所有的数对呢？例如，给定列表 [1, 2, 3]和列表[3, 4]，应该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代表数对
	public static void testStream1(){
		List<Integer> array1 = Arrays.asList(1,2,3);
		List<Integer> array2 = Arrays.asList(4,5);
		List<Stream<int[]>> lst = array1.stream()
		.map(i -> array2.stream()
				.map(j -> new int[]{i,j}))
		.collect(Collectors.toList());
		for(Stream<int[]> stream : lst){			
			stream.forEach(arr -> System.out.println("("+arr[0]+","+arr[1]+")"));
		}
	}
	//在上面函数结果的基础上，增加条件，只返回两数加和后能被3整除的坐标
	public static void testStream2(){
		List<Integer> array1 = Arrays.asList(1,2,3);
		List<Integer> array2 = Arrays.asList(4,5);
		List<Stream<int[]>> lst = array1.stream()
		.map(i -> array2.stream()
				.filter( j -> (j + i) % 3 == 0)
				.map(j -> new int[]{i,j})
			)
		.collect(Collectors.toList());
		for(Stream<int[]> stream : lst){			
			stream.forEach(arr -> System.out.println("("+arr[0]+","+arr[1]+")"));
		}
	}
	
}
