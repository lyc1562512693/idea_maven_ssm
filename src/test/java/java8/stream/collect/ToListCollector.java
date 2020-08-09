package java8.stream.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collector.Characteristics.*;

import java8.stream.base.Dish;
import java8.stream.base.Dish.Type;
/**
 * 自定义实时toList()的Collector比较java8自带的Collector的实现toList()，一般用于lst.stream().collect(Collector<>);
 * @author Rzxuser
 *
 * @param <T>
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>>{

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
		myToList();
		javaToList1();
		javaToList2();
	}
	public static void myToList(){
		List<Dish> lst = menu.stream().collect(new ToListCollector<Dish>());
		System.out.println("--------这是自定义实现的toList():"+lst);
	}
	public static void javaToList1(){
		List<Dish> lst = menu.stream().collect(Collectors.toList());
		System.out.println("--------这是java实现的toList():" + lst);
	}
	public static void javaToList2(){
		List<Dish> lst = menu.stream()
		.collect(
				ArrayList::new,//新建一个集合
				List::add,//定义累加器
				List::addAll//定义组合器
				);
		System.out.println("这是java实现的toList()的另一种写法:" + lst);
	}
	@Override
	public Supplier<List<T>> supplier() {
		return () -> new ArrayList<T>();
	}

	@Override
	public BiConsumer<List<T>, T> accumulator() {
		return (list,item) -> list.add(item);
	}

	@Override
	public BinaryOperator<List<T>> combiner() {
		return (lst1,lst2) ->{
			lst1.addAll(lst2);
			return lst1;
		};
	}

	@Override
	public Function<List<T>, List<T>> finisher() {
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH,CONCURRENT));
	}

}
