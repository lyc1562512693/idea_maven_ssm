package java8.stream.base;

import java.util.stream.Stream;

/**
 * 简单的无限流
 * iterate：用于根据某种规则来获取一个数列
 * generate:用于根据一个lambda表达式来生成一个数列
 * @author Rzxuser
 *
 */
public class UnlimitStream {

	public static void main(String[] args) {
		createUnlimitStream();
		fibonacci();
		generateNum();
	}
	/**
	 * 该流理论上没有尽头，视为无限流
	 * 使用iterate创建无限流
	 */
	public static void createUnlimitStream(){
		Stream.iterate(0, n -> n + 2)
		.limit(100)
		.forEach(i -> System.out.print(i + " "));
		//.forEach(System.out::print);
		System.out.println();
	}
	/**
	 * 实现斐波那契数列
	 */
	public static void fibonacci(){
		Stream.iterate(new int[]{0,1}, a -> new int[]{a[1], a[0] + a[1]})
		.limit(30)
		.map(a -> a[0])
		.forEach(i -> System.out.print(i + " "));
		System.out.println();
	}
	/**
	 * 使用generate创建无限流
	 */
	public static void generateNum(){
		Stream.generate(() -> Math.random()*10)//generate里传入一个supplier的函数式接口
		.limit(20)
		.forEach(i -> System.out.print(i + " "));
		System.out.println();
	}
}
