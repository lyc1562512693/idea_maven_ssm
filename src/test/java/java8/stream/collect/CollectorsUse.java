package java8.stream.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import java8.stream.base.Dish;
import java8.stream.base.Dish.Type;

/**
 * Collectors工具类使用
 * @author Rzxuser
 *
 */
public class CollectorsUse {

	private static List<String> strLst = Arrays.asList("tom","jack","linna","meachial","tom","jack","jack");
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
		//toList();
		//groupingBy();
		//counting();
		//maxByAndMinBy();
		//summarizingInt();
		//joining();
		//partitioningBy();
		//partitioningByPro();
		//myToListCollector();
		List<Dish> lst = menu.stream().collect(new ToListCollector<Dish>());
		System.out.println(lst);
	}
	/**
	 * toList():将流数据转为list集合返回
	 */
	public static void toList(){
		List<String> lst = strLst.stream()
		.collect(Collectors.toList());
		System.out.println(lst);
	}
	 
	/**
	 * counting():计算流中数据的个数
	 */
	public static void counting(){
		long l = strLst.stream()
		.collect(Collectors.counting());
		System.out.println(l);
	}
	/**
	 * maxBy(Comparator),minBy(Comparator):返回流中元素的按指定比较规则Comparator的最大最小值
	 */
	public static void maxByAndMinBy(){
		Optional<String> strMax = strLst.stream()
		.collect(Collectors.maxBy((i,j) -> i.compareTo(j)));
		Optional<String> strMin = strLst.stream()
				.collect(Collectors.minBy((i,j) -> i.compareTo(j)));
		System.out.println("最大值是：" + strMax + ",最小值是：" + strMin);
	}
	/**
	 * summarizingInt(IntFunction)：函数将流对象转为int后，对所有int值进行统计，包括求总数（count），值总和（sum）,最大最小值（max，min）,平均值（average）
	 */
	public static void summarizingInt(){
		IntSummaryStatistics summariz = menu.stream()
		.collect(Collectors.summarizingInt(menu -> menu.getCalories()));
		System.out.println(summariz);
	}
	/**
	 * joining：将所给集合各个值连接起来
	 */
	public static void joining(){
		String str = menu.stream()
		.map(dish -> dish.getName())
		.collect(Collectors.joining(","));
		System.out.println(str);
	}
	/**
	 * 分组
	 * groupingBy(Function<T,R>):将流返回为以R为key，相同的T放在一起组成的lst为value的map集合
	 */
	public static void groupingBy(){
		Map<Integer, List<String>> strMap = strLst.stream()
		.collect(Collectors.groupingBy(str -> str.length()));
		System.out.println(strMap);
	}
	/**
	 * 分区（分组的一个特例，key只有true和false）
	 * partitionBy(Predicate):根据boolean结果将集合对象分组
	 */
	public static void partitioningBy(){
		Map<Boolean,List<Dish>> map = menu.stream()
		.collect(Collectors.partitioningBy(dish -> dish.getVegetarian()));
		System.out.println(map);
	}
	/**
	 * 先分区再分组
	 */
	public static void partitioningByPro(){
		Map<Boolean, Map<Type, List<Dish>>> map = menu.stream()
		.collect(Collectors.partitioningBy(Dish :: getVegetarian, Collectors.groupingBy(Dish::getType)));
		System.out.println(map);
	}
	public static void myToListCollector(){
		List<Dish> lst = menu.stream()
		.collect(
				ArrayList::new,//新建一个集合
				List::add,//定义累加器
				List::addAll//定义组合器
				);
		System.out.println(lst);
	}
	
	class MyString{
		public int length(){
			return 1;
		}
	}
}
