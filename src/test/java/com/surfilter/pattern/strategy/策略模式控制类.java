package com.surfilter.pattern.strategy;

public class 策略模式控制类 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/**
	 *策略类公共接口
	 * @author Rzxuser
	 *
	 */
	public interface Strategy{
		int getResult(int x, int y);
	}
	/**
	 * 策略实现类
	 * @author Rzxuser
	 *
	 */
	public class StrategyAdd implements Strategy{

		@Override
		public int getResult(int x, int y) {
			// TODO Auto-generated method stub
			return x+y;
		}
		
	}
	public class StrategySub implements Strategy{

		@Override
		public int getResult(int x, int y) {
			// TODO Auto-generated method stub
			return x-y;
		}
	}
	/**
	 * 具体策略控制类
	 * @author Rzxuser
	 *
	 */
	public class Context{
		//私有化策略类公共接口
		private Strategy strategy;
		
		//使用公共的set方法初始化strategy属性,,或者使用构造函数，但是使用构造函数时会导致要new多个Context对象
		public void setStrategy(Strategy strategy){
			this.strategy = strategy;
		}
		
		//在context策略控制类方法中调用策略类的公共方法，同时可以在核心方法调用前后加上公共的操作
		public int executeStrategy(int x, int y){
			System.out.println("我要开始计算了。。。。。。");
			int result = strategy.getResult(x, y);
			System.out.println("我已经计算完成了。。。。。。");
			return result;
		}
	}
}
