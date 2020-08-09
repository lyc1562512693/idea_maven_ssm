package java8.stream.collect;

import java.util.Arrays;
import java.util.List;

import java8.stream.base.Dish;
import java8.stream.base.Dish.Type;

public class Partition {

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
		// TODO Auto-generated method stub

	}
	public static void commonPartition(){

	}
}
