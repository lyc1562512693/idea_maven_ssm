package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口：就是只定义了一个抽象方法的接口（有且仅有一个抽象方法，可以有多个其他默认方法）
 * 四大核心函数式接口：
 * Consumer：accept（消费型接口）:传入T，返回void
 * Supplier:get（供给型接口）：传入void，返回T
 * Function:apply（转换型接口）：传入T，返回R
 * Predicate:test（判断型接口）：传入T，返回boolean
 * @author Rzxuser
 *
 */
public class FunctionalInterface {

	public static void main(String[] args) {
		//Predicate接口调用
		initPredicate();
		//Consumer接口调用
		List<Integer> resLst = initConsumer();
		System.out.println(resLst);
		System.out.println("------------");
		initConsumerPro();
		System.out.println("------------");
		//Function接口调用
		initFunction();
		//Supplier接口调用
		initSupplier();
	}
	
	/**
	 * 函数式接口Predicate实战
	 * @param lst
	 * @param pre
	 * @return
	 */
	public static <T> List<T> filter(List<T> lst, Predicate<T> pre){
		List<T> resLst = new ArrayList<>();
		for(T t : lst){
			if(pre.test(t)){
				resLst.add(t);
			}
		}
		return resLst;
	}
	/**
	 * 根据传入的参数对象返回boolean值，一般用于判断与校验
	 */
	public static void initPredicate(){	
		List<String> inLst = Arrays.asList("tom","linna","jackson");
		List<String> outLst = filter(inLst, (String str) -> str.length() > 2);
		System.out.println(outLst);
	}
	/**
	 * 函数式接口Consumer实战1
	 * 经验总节：accept为傀儡方法，对于传入的对象如果是基本类型则在lambda逻辑中不能改变其值。
	 * @param lst
	 * @param con
	 */
	public static <T> void foreach(List<T> lst, Consumer<T> con){
		for(T t : lst){
			con.accept(t);
		}
	}
	public static <T> List<Integer> initConsumer(){
		List<Integer> intLst = Arrays.asList(1,2,3,4,5,6);
		List<Integer> midLst = new ArrayList<>();
		foreach(intLst, (Integer i) -> {//基本类型不能再函数处理后改变,无法在foreach中改变集合，只能通过这种方式改变
			i = i*2;
			midLst.add(i);//intLst集合不能被改变，只能将改变后的值放到新集合中
			//return midLst;
		});
		return midLst;
	}
	/**
	 * 函数式接口Consumer实战2
	 * 经验总结：对于传入的对象如果是引用类型则在lambda逻辑中可以改变其值
	 * @param lst
	 * @param con
	 * @return
	 */
	public static <T> void foreachPro(List<T> lst, Consumer<T> con){
		for(T t : lst){
			con.accept(t);
		}
	}
	/**
	 * 表达式传入user对象，但是仅作逻辑处理，不返回任务参数
	 */
	public static void initConsumerPro(){
		List<User> inLst = Arrays.asList(new User("tom",1),new User("lina",2));
		System.out.println("原始对象集合：" + inLst);
		foreachPro(inLst, (User user) -> user.setId(user.getId()+10));//在lambda逻辑中改变user对象的值
		System.out.println("经过consumerPro改变后的对象集合：" + inLst);
	}
	/**
	 * 函数式接口Function<T, R>实战
	 * 经验总结：用于进行类型转换，将输入的T类型转换为R类型
	 * @param lst
	 * @param func
	 * @return
	 */
	public static <T, R> List<R> mineMap(List<T> lst, Function<T,R> func){
		List<R> reslst = new ArrayList<>();
		for(T t : lst){
			reslst.add(func.apply(t));
		}
		return reslst;
	}
	/**
	 * 表达式传入一种类型，返回另一种类型(一般用于类型转换，对象的属性改变一般用Consumer，参initConsumerPro)
	 */
	public static void initFunction(){
		List<String> inLst = Arrays.asList("tom","lina","jackson");
		List<Integer> outLst = mineMap(inLst, (String str) -> str.length());
		System.out.println(outLst);
	}
	/**
	 * 函数式接口Supplier<T>实战
	 * @param sup
	 * @return
	 */
	public static <T> List<T> convert(Supplier<T> sup){
		List<T> resLst = new ArrayList<>();
		for(int i = 0; i < 10; i++){		
			resLst.add(sup.get());
		}
		return resLst;
	}
	/**
	 * 表达式不传入任务参数，但是返回参数
	 */
	public static void initSupplier(){
		List<Integer> outLst = convert(() -> (int)(Math.random()*10));
		System.out.println(outLst);
	}
	static class User{
		private String name;
		private int id;
		
		public User(String name, int i) {
			super();
			this.name = name;
			this.id = i;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "User [name=" + name + ", id=" + id + "]";
		}
	}
 }
