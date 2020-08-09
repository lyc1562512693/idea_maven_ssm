package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

/**
 * 原始（基本）类型->应用类型：装箱
 * 反之：拆箱
 *Lambda可以理解为一个支持函数式的对象（即等效于一个@FunctionalInterface对象）：该对象的描述为     传入参数->返回参数
 * 类型推断：通过类型推断可以去掉传入参数的类型
 * @author Rzxuser
 *
 */
public class TypeConvert {

	public static List<String> inlst= Arrays.asList("tcom","jacksd","mechal","king","jane");
	public static void main(String[] args) {
		initIntPredicate();
		initConsumer();
		System.out.println("---------");
		initSupplier();
		System.out.println("---------");
		initFunction();
	}
	/**
	 * 使用IntPredicate函数式接口，避免装箱操作
	 * @param inLst
	 * @param intPre
	 * @return
	 */
	public static List<Integer> intFilter(List<Integer> inLst, IntPredicate intPre){
		List<Integer> outLst = new ArrayList<>();
		for(Integer i : inLst){
			if(intPre.test(i)){
				outLst.add(i);//特殊情况：该行代码是一个语句表达式，因此虽然是返回了一个boolean，但是也可以认为反回了void
			}
		}
		return outLst;
	}
	public static void initIntPredicate(){
		List<Integer> inLst = Arrays.asList(1,2,3,4,5,6);
		List<Integer> outLst = intFilter(inLst, i -> i % 2 == 0);
		System.out.println(outLst);
	}
	
	public static <T> void foreach(List<T> lst, Consumer<T> con){
		for(T t : lst){
			con.accept(t);
		}
	}
	public static void initConsumer(){
		foreach(inlst, i -> System.out.print(i+","));
		System.out.println();
	}
	public static <T> List<T> provide(Supplier<T> sup){
		List<T> resLst = new ArrayList<>();
		for(int i = 0;i< 10;i++){
			resLst.add(sup.get());
		}
		return resLst;
	}
	public static void initSupplier(){
		List<Double> outLst2 = provide(Math::random);//使用引用方式有限制，有些逻辑不支持
		List<Integer> outLst = provide(() -> (int)(Math.random()*10));
		System.out.println(outLst);
		System.out.println(outLst2);
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
		List<Integer> lst = mineMap(inlst, str -> str.length());
		System.out.println(lst);
	}
}
