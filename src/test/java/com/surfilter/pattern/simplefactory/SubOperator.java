package com.surfilter.pattern.simplefactory;
/**
 * 减法运算实现类
 * @author Rzxuser
 *
 */
public class SubOperator implements Operator{

	@Override
	public int getResult(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

}
