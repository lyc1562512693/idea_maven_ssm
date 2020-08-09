package com.surfilter.pattern.strategy.factoryAStrategy;

public class Context {

	private CashSuper cashSuper = null;
	
	public void  setConetext(CashSuper cashSuper){
		this.cashSuper = cashSuper;
	}
	public double executeStrategy(double money){
		double cash = 0;
		System.out.println("折扣方法执行前，先计算商品总价！");
		if(money <= 0){
			System.out.println("你暂未购买任何商品，请选择商品后再来！");
		}else{
			System.out.println("商品总价称量完毕，正在进行折扣计算。");
			cash = cashSuper.getCash(money);//核心方法
			System.out.println("折扣成功，打折后您应支付：" + cash + "元");
		}
		System.out.println("欢迎下次再来。");
		return cash;
	}
}
