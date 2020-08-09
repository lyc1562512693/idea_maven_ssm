package mjp;

public class Student implements Person {

	private String name;
	
	public Student(String name) {
		super();
		this.name = name;
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"上交班费");
	}

}
