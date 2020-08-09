package java8.stream.base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatStream {

	public static void main(String[] args) {
		commonStream();
		//flatStream();
		//flatStreamDesc();
	}
	/**
	 * str = {"tomson","jackson","joneson"}
	 * 普通流(最终str被转化为三个流[t,o,m,s,o,n],[j,a,c,k,s,o,n],[j,o,n,e,s,o,n])
	 */
	public static void commonStream(){
		List<String> lst = Arrays.asList("tomson","jackson","joneson");
		List<String[]> strArrayLst = lst.stream()
		.map(str -> str.split(""))
		.collect(Collectors.toList());
		for(String[] string : strArrayLst){
			System.out.println(string.toString());
		}
		System.out.println(strArrayLst.get(0).toString());
	}
	/**
	 * 扁平化流
	 * str = {"tomson","jackson","joneson"}
	 * (1)假扁平化流：最终str被转化为6+7+7个流[[t],[o],[m],[s],[o],[n],[j],[a],[c],[k],[s],[o],[n],[j],[o],[n],[e],[s],[o],[n]]
	 * (2)真正的扁平化流：最终转化为一个流[t,o,m,s,o,n,j,a,c,k,s,o,n,j,o,n,e,s,o,n]
	 * 
	 */
	public static void flatStreamDesc(){
		String[] strArray = {"tomson", "jackson", "joneson"};
		//将字符串数组转换为流,对于list，则为list.stream().
		Stream<String> strStream = Arrays.stream(strArray);
		List<Stream<String>> streamList = strStream
				.map(string -> string.split(""))
				.map(s -> Arrays.stream(s))
				.collect(Collectors.toList());
		for(Stream<String> stream : streamList){			
			System.out.println(stream.collect(Collectors.toList()));
		}//(1)
		
		Stream<String> strStream2 = Arrays.stream(strArray);
		List<String> streamList2 = strStream2
		.map(string -> string.split(""))
		.flatMap(sArray -> Arrays.stream(sArray))
		.collect(Collectors.toList());
		System.out.println(streamList2);//(2)
	}
	public static void testflatStream(){}
}
