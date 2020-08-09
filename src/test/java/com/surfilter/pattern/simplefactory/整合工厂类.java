package com.surfilter.pattern.simplefactory;
/**
 * 该方式其实也同时用到了策略
 * @author Rzxuser
 *
 */
public class 整合工厂类 {
	
	public static void main(String[] args) {
		Operator op = new 整合工厂类().calculate("+");
		int s = op.getResult(10, 2);
		System.out.println(s);
		
		// 使用lamoda实现工厂模式
		int x = 1;
		int y = 3;
		calculateL(x, y, (int a, int b) -> a + b);
		calculateL(x, y, (int a, int b) -> a - b);
		calculateL(x, y, (int a, int b) -> a * b);
		calculateL(x, y, (int a, int b) -> a / b);
		calculateL(x, y, (int a, int b) -> a % b);
	}
	/**
	 * 核心工厂方法
	 * @param calc
	 * @return
	 */
	public Operator calculate(String calc){
		Operator operator = null;
		switch(calc){//根据不同需求生产不同运算实现类，并由公共接口接收
		case "+" :
			operator = new AddOperator();
			break;
		case "-" :
			operator = new SubOperator();
			break;
		case "*" :
			operator = new MultiOperator();
			break;
		case "/" :
			operator = new DivideOperator();
			break;
		}
		return operator;
	}
	/**
	 * 使用Lambda替代工厂模式
	 * @param a
	 * @param b
	 * @param op
	 * @return
	 */
	public static int calculateL(int a,int b,Operator op){
		return op.getResult(a, b);
	}
	/**
	 * 运算内部类接口
	 * @author Rzxuser
	 *
	 */
	public interface Operator {

		int getResult(int a, int b);
	}
	/**
	 * 各种累不累运算实现类
	 * @author Rzxuser
	 *
	 */
	public class AddOperator implements Operator{
		
		@Override
		public int getResult(int a, int b){
			return a+b;
		}
		
	}
	public class SubOperator implements Operator{

		@Override
		public int getResult(int a, int b) {
			// TODO Auto-generated method stub
			return a-b;
		}

	}
	public class MultiOperator implements Operator{

		@Override
		public int getResult(int a, int b) {
			// TODO Auto-generated method stub
			return a*b;
		}

	}
	public class DivideOperator implements Operator{

		@Override
		public int getResult(int a, int b) {
			// TODO Auto-generated method stub
			return a/b;
		}

	}
}
