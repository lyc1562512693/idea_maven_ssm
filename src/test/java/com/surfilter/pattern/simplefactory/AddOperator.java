package com.surfilter.pattern.simplefactory;
/**
 * 加法运算实现类
 * @author Rzxuser
 *
 */
public class AddOperator implements Operator{
	
	@Override
	public int getResult(int a, int b){
		return a+b;
	}
	
}
