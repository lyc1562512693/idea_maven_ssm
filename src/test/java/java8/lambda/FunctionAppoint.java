package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

/**
 * 方法引用
 * @author Rzxuser
 *
 */
public class FunctionAppoint {

	public static List<String> inlst = Arrays.asList("tom","linda","King","swort");
	public static void main(String[] args) {
		initConsumer();
		initSupplier();
		initFunction();
	}
	public static List<Integer> intFilter(List<Integer> inLst, IntPredicate intPre){
		List<Integer> outLst = new ArrayList<>();
		for(Integer i : inLst){
			if(intPre.test(i)){
				outLst.add(i);
			}
		}
		return outLst;
	}
	public static void initIntPredicate(){
		List<Integer> inLst = Arrays.asList(1,2,3,4,5,6);
		List<Integer> outLst = intFilter(inLst, i -> i % 2 == 0);
		System.out.println(outLst);
		//intFilter(inLst, i % 2  :: 0);
		IntPredicate intpre1 = i -> i % 2 == 0;
		intpre1.test(1);
		
		//IntPredicate intpre2 = Boolean :: ;
	}
	
	public static <T> void foreach(List<T> lst, Consumer<T> con){
		for(T t : lst){
			con.accept(t);
		}
	}
	public static void initConsumer(){
		//foreach(inlst, i -> System.out.print(i+","));
		foreach(inlst, System.out::print);
		List<Integer> resLst = new ArrayList<>();
		foreach(inlst, i -> resLst.add(i.length()));//特殊情况：该行代码是一个语句表达式，因此虽然是返回了一个boolean，但是也可以认为反回了void
		System.out.println(resLst);
	}
	public static <T> List<T> provide(Supplier<T> sup){
		List<T> resLst = new ArrayList<>();
		for(int i = 0;i< 10;i++){
			resLst.add(sup.get());
		}
		return resLst;
	}
	public static void initSupplier(){
		//List<Integer> outLst1 = provide(() -> (int)(Math.random()*10));
		//System.out.println(outLst1);
		List<Double> outLst2 = provide(Math :: random);
		System.out.println(outLst2);
		
		Supplier<String> sup1 = () -> "King";
		Supplier<String> sup2 = String :: new;
	}
	public static <T, R> List<R> mineMap(List<T> inLst, Function<T, R> func){
		List<R> outLst = new ArrayList<>();
		for(T t : inLst){
			R r = func.apply(t);
			outLst.add(r);
		}
		return outLst;
	} 
	public static void initFunction(){
		//List<Integer> lst1 = mineMap(inlst, str -> str.length());
		//System.out.println(lst1);
		List<Integer> lst2 = mineMap(inlst, String :: length);
		System.out.println(lst2);
	}
}
