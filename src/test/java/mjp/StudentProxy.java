package mjp;

public class StudentProxy implements Person {

	private Student student;
	
	public StudentProxy(Student student){
		this.student = student;
	}
	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("班长帮学生交班费前要做啥");
		student.pay();
		System.out.println("班长帮学生交班费后要做啥");
	}

}
