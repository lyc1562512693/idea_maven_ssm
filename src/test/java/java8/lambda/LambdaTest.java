package java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * () -> {}
 * 关于后面的要不要加{}？
 * 如果后面是语句则可加可不加，如果是return语句，则要加
 * 不是语句一定不要加
 * 非return的语句的表达式都可以视为返回值为void的类型：eg1：System.out.print(); eg2:list.add(x); eg3: x = i + j;
 * @author Rzxuser
 *
 */
public class LambdaTest {

	public static void main(String[] args) {
		List<Integer> inlst = Arrays.asList(new Integer(1),new Integer(2),new Integer(12));
		List<Integer> outlst =  filter(inlst, (Integer t) -> t > 1);
		System.out.println(outlst.toString());
		
		List<StringBuilder> infruits = Arrays.asList(new StringBuilder("apple"),new StringBuilder("pear"),new StringBuilder("watermelon"));
		List<StringBuilder> outfruits = filter(infruits, (StringBuilder sb) ->  !"apple".equals(sb.toString()));
		System.out.println(outfruits.toString());
		
		filter2(() -> {});
		
		myThread();
		//myThreadPro();
		
		myCompare();
	}
	public static void filter2(Predict2 p2){
		System.out.println("这是个无参数无返回值的Lambda表达式");
		p2.test2();
	}
	interface Predict2{
		void test2();
	}
	public static <T> List<T> filter(List<T> lst, Predict<T> p){
		List<T> relst = new ArrayList<>();
		for(T t : lst){			
			if(p.test(t)){
				relst.add(t);	
			}
		}
		return relst;
	}
	
	interface Predict<T>{
		Boolean test(T t);
	}
	
	public static void myThread(){
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("线程方法1开始了");
				System.out.println("线程方法1结束了");
			}
		}); 
		t1.start();
		
		Thread t2 = new Thread(() -> {
			System.out.println("线程方法2开始了");
			System.out.println("线程方法2结束了");
		});
		t2.start();
	}
	@Test
	public  void myThreadPro(){
		Thread t1 = new Thread(new Runnable() {
			String name = "大马哈鱼";
			@Override
			public void run() {
				System.out.println(name + "开始了");
				
			}
		});
		t1.start();
		
		String name2 = "金枪鱼";
		Thread t2 = new Thread(() -> {String i = "123";System.out.println(name2 + "开始了" + i);i ="234";
			System.out.println(i);});
		t2.start();
	}
	
	public static void myCompare(){
		Comparator<Integer> com1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1/o2);
			}
		};
		System.out.println(com1.compare(8, 2));
	
		Comparator<Integer> com2 = (Integer a1,Integer a2) -> a2.compareTo(a1 / a2);
		System.out.println(com2.compare(8, 2));
	}
}
