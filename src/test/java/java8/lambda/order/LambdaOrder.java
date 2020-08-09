package java8.lambda.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;

public class LambdaOrder {

	private static List<Apple> lst = Arrays.asList(new Apple(3,"green"),new Apple(8,"red"),new Apple(4, "gray"),new Apple(1,"white"));
	
	public static void main(String[] args) {
		
		//orderImpl();
		//orderInnerClass();
		//orderCommonLambda();
		orderAppointLambda();
	}
	/**
	 * 使用实现类实现排序
	 */
	public static void orderImpl(){
		
		lst.sort(new ImplemetOrder());
		System.out.println(lst);
	}
	/**
	 * 匿名内部类实现排序
	 */
	public static void orderInnerClass(){
		lst.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
			
		});
		System.out.println(lst);
	}
	/**
	 * 类型推断Lambda实现排序
	 */
	public static void orderCommonLambda(){
		lst.sort((a1,a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(lst);
	}
	/**
	 * 方法引用Lambda实现排序(注意要静态导入comparing)
	 */
	public static void orderAppointLambda(){
		lst.sort(comparing(Apple :: getWeight));
		System.out.println(lst);
	}
	
}
