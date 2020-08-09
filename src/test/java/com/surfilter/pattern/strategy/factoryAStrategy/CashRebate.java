package com.surfilter.pattern.strategy.factoryAStrategy;

public class CashRebate implements CashSuper {

	//折扣率,默认为1，不打折
	private double discount = 1;
	public CashRebate(double discount){
		this.discount = discount;
	}
	@Override
	public double getCash(double money) {
		// TODO Auto-generated method stub
		return money*discount;
	}

}
