package java8.stream.practice;

/**
 * 交易员类
 * @author Rzxuser
 *
 */
public class Trader {

	private String name;//交易员姓名
	private String city;//交易员工作城市
	
	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + "]";
	}
	
}
