package com.surfilter.pattern.strategy;

public class StrategyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strategy strategy = new StrategyAdd();//初始化实际策略对象
		Context context = new Context(strategy);//初始化策略控制类
		int result = context.executeStrategy(10, 2);//该方法根据传入的不同策略类来判断执行对应的方法
		System.out.println(result);
	}

}
