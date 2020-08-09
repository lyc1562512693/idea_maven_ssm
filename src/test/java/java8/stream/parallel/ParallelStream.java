package java8.stream.parallel;

import java.util.stream.Stream;

/**
 * 并行流:将数据拆分成多个数据块，并行处理各个数据块中的流，拆的个数默认为cpu核数。
 * 并行流不一定比顺序流块，要根据场景来选择合适的方式
 * 常见流数据源的可分解（并行）性：
 * ArrayList:极佳
 * LinkedList:差
 * IntStream.range:极差（并行化时多了装箱拆箱的过程）
 * Stream.iterate:差（iterate本身不好拆分）
 * HashSet:好
 * TreeSet:好
 * @author Rzxuser
 *
 */
public class ParallelStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createParallelStream();
	}
	public static void createParallelStream(){
		int x = Stream.iterate(0, i -> i + 1)
		.limit(10)
		.parallel()
		//.reduce(0, (a,b) -> a + b);
		.reduce(0, Integer::sum);
		System.out.println(x);
	}

}
