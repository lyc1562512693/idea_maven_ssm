package sorttest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		List lst = new ArrayList<>();
		for(int i = 10;i>0;i--){
			User u = new User(i, "user"+i);
			lst.add(u);
		}
		System.out.println(lst);
		System.out.println(compare(lst));
	}
	public static List<User> compare(List<User> lstUser){
		Collections.sort(lstUser,new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return o1.getAge() - o2.getAge();
			}
			
		});
		return lstUser;
	}

}
