package java8.stream.practice;

/**
 * 交易事件类
 * @author Rzxuser
 *
 */
public class Transaction {

	private Trader trader;//交易员
	private Integer year;//发生交易年份
	private Integer value;//交易额
	
	public Transaction(Trader trader, Integer year, Integer value) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}
	public Trader getTrader() {
		return trader;
	}
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + "]";
	}
	
}
