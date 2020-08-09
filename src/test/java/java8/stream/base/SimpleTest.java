package java8.stream.base;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java8.stream.base.Dish.Type;

import static java.util.stream.Collectors.toList;
/**
 * 简单的流式处理
 * 注意：流只能被消费一次
 * 终端操作：collect,count,forEach
 * 凡是返回stream的皆为中间操作，返回非stream的皆为终端操作
 * @author Rzxuser
 *
 */
public class SimpleTest {

	public static List<Dish> menu = Arrays.asList(
			new Dish("pork",false,800,Type.MEAT),
			new Dish("beef",false,850,Type.MEAT),
			new Dish("chicken",false, 450, Type.MEAT),
			new Dish("milk",true, 400, Type.OTHER),
			new Dish("rice",true,200, Type.OTHER),
			new Dish("apple", true, 150,Type.OTHER),
			new Dish("pizza", true, 450,Type.OTHER),
			new Dish("shark", false,700,Type.FISH),
			new Dish("goldfish",false, 250,Type.FISH)
			);
	
	public static void main(String[] args) {
		//filterMenu();
		//printFilterMenu();
		//stringStream();
		//forEachStream();
		//mapStream();
		//matchStream();
		//findStream();
		//mergeStream();
		findMaxAndMin();
	}
	public static void filterMenu(){
		List<Integer> myBreakfast = menu.stream()
				.filter(dish -> dish.getVegetarian())//内部调用predicate,使用bool条件进行过滤赛选
				.map(dish -> dish.getCalories())//内部调用function，用于类型转换
				.sorted((i,j) -> i.	compareTo(j))//内部调用comparetor接口，用于两两比较
				.limit(3)
				.collect(toList());
		System.out.println(myBreakfast);
	}
	public static void printFilterMenu(){
		List<Integer> myBreakfast = menu.stream()
				.filter(dish -> {
					System.out.println("filtering-" + dish.getName());
					return !dish.getVegetarian();
				}).map(dish -> {
					System.out.println("mapping-" + dish.getName());
					return dish.getCalories();
				}).sorted((a,b) -> {
					System.out.println("sorted-" + a + "," + b);
					return a.compareTo(b);
				}).limit(3)
				.collect(toList());
		System.out.println(myBreakfast);
	}
	
	public static void stringStream(){
		
		List<String> inLst = Arrays.asList("tom","tom","jackon","111222","&&","linna","w");
		//List<Integer> inLst = Arrays.asList(1,2,3,3,9,4,6);
		inLst.stream()
		.filter(str -> str instanceof String)
		.distinct()//去重s
		.map(str -> str.length())
		.skip(5)//取个数
		.forEach(i -> System.out.print(i));//内部调用consumer接口，将传入的值进行输出，处理等操作，但不返回新东西
		System.out.println();
		inLst.stream()
		.filter(str -> str instanceof String)
		.distinct()//去重s
		.map(str -> str.length())
		.limit(5)//取个数
		.forEach(i -> System.out.print(i));
		//System.out.println(outLst);
	}
	public static void forEachStream(){
		menu.stream()
		.forEach(dish -> {
			dish.setCalories(0);
			dish.setVegetarian(true);
		});
		System.out.println(menu);
	}
	public static void mapStream(){
		List<Integer> lengthLst = menu.stream()
		.map(Dish :: getName)
		.map(String :: length)
		.collect(toList());
		System.out.println(lengthLst);
	}
	/**
	 * 返回流的内容是否匹配
	 */
	public static void matchStream(){
		boolean  b = menu.stream()
		.allMatch(dish -> dish.getVegetarian());//内部调用predicate,使用bool条件进行过滤赛选
		System.out.println(b);
		boolean b2 = menu.stream()
		.anyMatch(dish -> dish.getCalories() == 700);//内部调用predicate,使用bool条件进行过滤赛选
		System.out.println(b2);
	}
	/**
	 * 返回流中的任一个或第一个元素
	 * 注意Optional,这个Optional可以避免返回空值的现象
	 * Optional:isPresent(),ifPresent(Consumer<T> block)
	 */
	public static void findStream(){
		Optional<Dish> cai= menu.stream()
		.filter(dish -> dish.getVegetarian())
		.findAny();//findfirst()
		System.out.println(cai.get());
	}
	/**
	 * 对集合中数据进行叠加（融合）操作（最后合为一个元素）
	 */
	public static void mergeStream(){
		List<Integer> intLst = Arrays.asList(1,2,3);
		int res = intLst.stream()
		.reduce(10, (i,j) -> i+j);
		System.out.println(res);
		int res2 = intLst.stream()
		.reduce(5,(i,j) -> i*j);//5*1*2*3=30
		System.out.println(res2);
	}
	public static  void findMaxAndMin(){
		List<Integer> intLst = Arrays.asList(1,3,4,7,9,2);
		Optional<Integer> max = intLst.stream()
				.reduce(Integer::max);
		Optional<Integer> min = intLst.stream()
				.reduce(Integer::min);
		Optional<Integer> sum = intLst.stream()
				.reduce(Integer::sum);
		System.out.println("最大值为：" + max.get() + "，最小值为：" + min.get() + "，所有值和为：" + sum.get());
	}
}
	