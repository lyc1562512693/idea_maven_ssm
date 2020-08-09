package java8.stream.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 交易统计类（stream处理实战）
 * @author Rzxuser
 *
 */
public class StatisStream {

	private List<Trader> traders = Arrays.asList(
			new Trader("tom","henan"),
			new Trader("lina","hebei"),
			new Trader("lining","henan"),
			new Trader("laowang","hubei")
			);

	public static void main(String[] args) {
		Trader tom = new Trader("Tom","henan");
		Trader lina = new Trader("Lina","hebei");
		Trader lining = new Trader("Lining","henan");
		Trader laowang = new Trader("Laowang","hubei");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(tom,2000,998),
				new Transaction(tom,2011,199990),
				new Transaction(tom,2005,1880),
				new Transaction(lina,2011,99),
				new Transaction(lina,2011,899),
				new Transaction(lina,2002,38800),
				new Transaction(lining,2018,99999),
				new Transaction(laowang,2012,9999999),
				new Transaction(laowang,2011,8000)
				);
		findAndOrderTrans(transactions);
		outCity(transactions);
		findHeNanAndOrderByName(transactions);
		findNameStrAndOrder(transactions);
		findIfHuBei(transactions);
		outHeBeiValue(transactions);
		sumValue(transactions);
		maxAndMinValue(transactions);
	}
	/**
	 * 找出2011年发生的所有交易，并按交易额排序（从低到高）。
	 */
	public static void findAndOrderTrans(List<Transaction> transactions){
		List<Transaction> res = transactions.stream()
		.filter(trans -> trans.getYear() == 2011)
		.sorted((i,j) -> i.getValue().compareTo(j.getValue()))
		.collect(Collectors.toList());
		System.out.println(res);
	}
	/**
	 * 交易员都在哪些不同的城市工作过？
	 * @param transactions
	 */
	public static void outCity(List<Transaction> transactions){
		transactions.stream()
		.map(trans -> trans.getTrader().getCity())
		.distinct()
		.forEach(city -> System.out.println(city));
	}
	/**
	 * 查找所有来自于剑桥的交易员，并按姓名排序
	 * @param transactions
	 */
	public static void findHeNanAndOrderByName(List<Transaction> transactions){
		transactions.stream()
		.map(Transaction :: getTrader)
		.filter(trader -> "henan".equals(trader.getCity()))
		.distinct()
		.sorted((trader1,trader2) -> trader1.getName().compareTo(trader2.getName()))
		.forEach(traderr -> System.out.println(traderr));
	}
	/**
	 * 返回所有交易员的姓名字符串，按字母顺序排序。
	 * @param transactions
	 */
	public static void findNameStrAndOrder(List<Transaction> transactions){
		transactions.stream()
		.map(trans -> trans.getTrader().getName().split(""))
		.flatMap(str -> Arrays.stream(str))
		.distinct()
		.sorted((str1,str2) -> str1.compareTo(str2))
		.forEach(str -> System.out.print(str + " "));
		System.out.println();
	}
	/**
	 * 有没有交易员是在米兰工作的？
	 * @param transactions
	 */
	public static void findIfHuBei(List<Transaction> transactions){
		boolean ifHeBei = transactions.stream()
		.map(trans -> trans.getTrader())
		.anyMatch(trader -> "hebei".equals(trader.getCity()));
		System.out.println(ifHeBei);
	}
	/**
	 * 打印生活在剑桥的交易员的所有交易额
	 * @param transactions
	 */
	public static void outHeBeiValue(List<Transaction> transactions){
		transactions.stream()
		.filter(trans -> "henan".equals(trans.getTrader().getCity()))
		.map(trans -> trans.getValue())
		.distinct()
		.forEach(i -> System.out.print(i + " "));
		System.out.println();
	}
	/**
	 * 打印生活在剑桥的交易员的所有交易额总和
	 * @param transactions
	 */
	public static void sumValue(List<Transaction> transactions){
		Optional<Integer> totalValue = transactions.stream()
		.filter(trans -> "henan".equals(trans.getTrader().getCity()))
		.map(trans -> trans.getValue())
		.reduce(Integer::sum);
		System.out.println(totalValue.get());
	}
	/**
	 * 所有交易中，最高和最小的交易额
	 * @param transactions
	 */
	public static void maxAndMinValue(List<Transaction> transactions){
		Optional<Integer> maxValue = transactions.stream()
		.map(trans -> trans.getValue())
		.reduce(Integer :: max);
		Optional<Integer> minValue = transactions.stream()
				.map(trans -> trans.getValue())
				.reduce(Integer :: min);
		System.out.println("所有交易中,最大交易额为：" + maxValue.get() + ",最小交易额为：" + minValue.get());
	}
}
