package mjp;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student st = new Student("lyc"); 
		Person sp = new StudentProxy(st);
		sp.pay();
	}

}
