package java8.stream.base;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 创建流的各种方式：从集合创建，也可从值、数组、文件以及iterate与generate等特定方法创建
 * 集合：lst.stream();
 * 数组：Array.stream(new int[]{1,2,3,4,5});
 * 直接：Stream.of("tom","jack","jane")
 * 文件：Files.lines(Paths.get("data.txt"), Charset.defaultCharset());
 * @author Rzxuser
 *
 */
public class CreateStream {

	public static void main(String[] args) {
		listStream();		
		readFileStream();
		valueStream();
		arrayStream();
	}
	/**
	 * 使用集合创建一个流
	 */
	public static void listStream(){
		List<String> str = Arrays.asList("tom","jack","jane");
		str.stream().forEach(s -> System.out.print(s + " "));
		System.out.println();
	}
	/**
	 * 使用值创建流
	 */
	public static void valueStream(){
		Stream.of("tom","jack","jane")
		.map(s -> s.length())
		.forEach(l -> System.out.print(l + " "));
		System.out.println();
	}
	/**
	 * 使用数组创建一个流
	 */
	public static void arrayStream(){
		Arrays.stream(new int[]{1,2,3,4,5})
		.forEach(i -> System.out.print(i + " "));
		System.out.println();
	}
	/**
	 * 文件流：使用一个文件内容创建一个流
	 * Files.lines，它会返回一个由指定文件中的各行构成的字符串流，其中的每个元素都是给定文件中的一行
	 */
	public static void readFileStream(){
		List<String> uniqueWords = null;
		try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split("")))
					.distinct()
					.collect(Collectors.toList());
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(uniqueWords);
	}
	//有函数创建流：Stream.iterate，Stream.generate,详见无限流类

}
