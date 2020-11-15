package mystr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

	public static void main(String[] args){
		String timeSource = "2019-01-10 16:29:00";
		String[] strArray = timeSource.split("[-\\s]");
		String timeDes = strArray[0]+strArray[1];
		System.out.println(timeDes);
		count();
		String s1 = "123";
		if("".equals(s1) || s1 == null){}
		if(s1.length() == 0 || s1 == null){}//效率高，推荐
		if(s1.isEmpty() || s1 == null ){}//和方式二一样
		int x = 123;
		Integer.toString(x).length();
		//out();
		regexp();
        countMan();
        List<String> lst2 = new ArrayList<>();
        //new ReadWriteLock();
		char[] c = s1.toCharArray();
		String[] s = lst2.toArray(new String[lst2.size()]);
		System.out.println("这是本地master修改");
        System.out.println("这是远程master修改");
	}
	public static void count(){
		float a = 10;
		int b = 3;
		float d = a/b;
		System.out.println(d);
	}
	public static void out(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println("string:"+str);
        int i = scanner.nextInt();
        System.out.println("int:" + i);

    }
    public static void regexp(){
		String regexp = "([a-z]&&^b)+";
		String str = "a23";
		Pattern p =Pattern.compile(regexp);
		Matcher m = p.matcher(str);
		m.matches();
		System.out.println(m.find());
	}
	public static void countMan(){
	    Scanner scanner = new Scanner(System.in);
	    String size = scanner.next();
	    String[] sArr = size.split(",");
	    int r = Integer.parseInt(sArr[0]);
	    int c = Integer.parseInt(sArr[1]);
	    char[][] fmArr = new char[r][c];
	    for(int i = 0;i < r; i++){
	        String col = scanner.next();
	        for(int j = 0; j < c; j+=2){
	            fmArr[i][j] = col.charAt(j);
            }
        }
	    //使用4条扫描线：水平，垂直，正负45°角
        int max = 0;
        //水平线求最大值
        for(int i = 0; i < r; i++){
            int temp = 0;
            for(int j = 0;j < c;j++){
                if(fmArr[i][j] == 'F')temp++;
            }
            if(temp > max)max = temp;
        }
        //垂直线求最大值
        for(int i = 0; i < c;i++){
            int temp = 0;
            for(int j = 0;j < r;j++){
                if(fmArr[j][i] == 'F')temp++;
            }
            if(temp > max)max = temp;
        }
        //正45°角求最大值
        for(int i = -(r-1); i < c;i++){
            for(int j = i+2;j < i+2;j++){
                //fmArr[j][j-i]
            }
        }
        System.out.println(fmArr);
    }
}
