package com.surfilter.pattern.strategy;
/**
 * 策略核心类
 * @author Rzxuser
 *
 */
public class Context {

	private Strategy strategy;//私有化策略类公共接口
	public Context(Strategy strategy){//构造函数初始化实际策略类
		this.strategy = strategy;
	}
	public int executeStrategy(int x,int y){
		System.out.println("核心方法执行前的公共的附加操作");
		int res = strategy.getResult(x, y);//调用策略类公共接口中的公共方法
		System.out.println("核心方法执行后的公共的附加操作");
		return res;
	}
}
