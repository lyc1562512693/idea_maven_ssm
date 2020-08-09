package timetest;

import java.util.Date;

public class MyTime {
	private static Integer i;
	public static void main(String[] args){
		long time1= System.currentTimeMillis();
		Date date =new Date();
		
		long time2= date.getTime();
		System.out.println(time1+"..."+time2);
		System.out.println(i);
	}

}
