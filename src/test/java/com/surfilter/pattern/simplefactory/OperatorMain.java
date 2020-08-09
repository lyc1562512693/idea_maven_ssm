package com.surfilter.pattern.simplefactory;

public class OperatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 18,b = 2;
		Operator op = OperatorFactory.calculate("/");
		int result = op.getResult(a, b);
		System.out.println(result);
		
	}

}
