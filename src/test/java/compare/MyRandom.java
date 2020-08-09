package compare;

import java.util.Random;

public class MyRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source="0123456789qwertyuiopasdfghjklzxcvbnm";
		rand(4,source);
	}
	
	public static void rand(int size,String source){
		Random r = new Random(System.currentTimeMillis());
		StringBuffer sb = new StringBuffer();
		while(size--!=0){
			int index=r.nextInt(source.length());			
			sb.append(source.charAt(index));			
		}
		System.out.println(sb);
	}

}
