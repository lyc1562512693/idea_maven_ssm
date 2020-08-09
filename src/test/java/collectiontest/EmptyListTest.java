package collectiontest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmptyListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<>();
		System.out.println(returnEmpty(list));
		
	}
	
	public static List<Object> returnEmpty(List<Object> list){
			return Collections.emptyList();
	}

}
