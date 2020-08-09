package com.surfilter.pattern.simplefactory;
/**
 * 工厂类，根据指定运算符来生产不同的运算类，来满足各种运算需求
 * @author Rzxuser
 *
 */
public class OperatorFactory {

	public static Operator calculate(String calc){
		Operator operator = null;
		switch(calc){//根据不同需求生产不同运算实现类，并由运算公共接口接收
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
}
