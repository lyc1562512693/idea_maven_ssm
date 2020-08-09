package mystr;

public class StringTest {

	public static void main(String[] args){
		String timeSource = "2019-01-10 16:29:00";
		String[] strArray = timeSource.split("[-\\s]");
		String timeDes = strArray[0]+strArray[1];
		System.out.println(timeDes);
		count();
	}
	public static void count(){
		float a = 10;
		int b = 3;
		float d = a/b;
		System.out.println(d);
	}
}
